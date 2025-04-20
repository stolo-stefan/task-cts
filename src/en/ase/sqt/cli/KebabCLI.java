package src.en.ase.sqt.cli;

import src.en.ase.sqt.builder.KebabBuilder;
import src.en.ase.sqt.factory.*;
import src.en.ase.sqt.model.Kebab;
import src.en.ase.sqt.model.sauces.Sauce;
import src.en.ase.sqt.persistence.*;

import java.util.*;

public class KebabCLI {
    private final Scanner inputScanner = new Scanner(System.in);
    private final List<Kebab> kebabList = new ArrayList<>();
    private final List<Sauce> customSauceList;
    private final SauceRepository sauceRepository;

    public KebabCLI() {
        this.sauceRepository = new FileSauceRepository("sauces.txt");
        this.customSauceList = sauceRepository.loadAll();
    }

    public void run() {
        menuLoop:
        while (true) {
            System.out.println("""
            -- Kebab CLI --
            1) Create Kebab
            2) List Kebabs
            3) Delete Kebab
            4) Filter Kebabs by Protein
            5) Add Custom Sauce
            6) Delete Custom Sauce
            7) Save Custom Sauces
            8) Reload Custom Sauces
            9) Exit""");
            System.out.print("→ ");
            String userChoice = inputScanner.nextLine().trim();
            switch (userChoice) {
                case "1" -> createKebab();
                case "2" -> listKebabs();
                case "3" -> deleteKebab();
                case "4" -> filterByProtein();
                case "5" -> addCustomSauce();
                case "6" -> deleteCustomSauce();
                case "7" -> {
                    sauceRepository.saveAll(customSauceList);
                    System.out.println("Saved.");
                }
                case "8" -> {
                    customSauceList.clear();
                    customSauceList.addAll(sauceRepository.loadAll());
                    System.out.println("Reloaded.");
                }
                case "9" -> {
                    System.out.println("Bye!");
                    break menuLoop;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void createKebab() {
        try {
            KebabBuilder builder = new KebabBuilder();
            System.out.print("Protein: ");
            builder.addProtein(IngredientFactory.createProtein(inputScanner.nextLine()));
            System.out.print("Carb: ");
            builder.addCarbohydrate(IngredientFactory.createCarbohydrate(inputScanner.nextLine()));

            // optional ingredients
            promptIfPresent("Pickle",  input -> builder.addPickle(IngredientFactory.createPickle(input)));
            promptIfPresent("Wrap",    input -> builder.addWrap(IngredientFactory.createWrap(input)));
            promptIfPresent("Fiber",   input -> builder.addFiber(IngredientFactory.createFiber(input)));
            promptIfPresent("Healthy", input -> builder.addHealthy(IngredientFactory.createHealthy(input)));

            // max 3 sauces per kebab
            for (int sauceIndex = 1; sauceIndex <= 3; sauceIndex++) {
                System.out.print("Add sauce #" + sauceIndex + "? (y/N) ");
                if (!inputScanner.nextLine().equalsIgnoreCase("y")) break;
                System.out.print(" Sauce name: ");
                String sauceName = inputScanner.nextLine();
                Optional<String> shelfLife = findShelfLifeForCustomSauce(sauceName);
                Sauce sauce = SauceFactory.create(sauceName, shelfLife);
                builder.addSauce(sauce);
            }

            Kebab builtKebab = builder.build();
            kebabList.add(builtKebab);
            System.out.println("Created: " + builtKebab);
        } catch (Exception exception) {
            System.out.println("error " + exception.getMessage());
        }
    }

    private void listKebabs() {
        if (kebabList.isEmpty()) {
            System.out.println("No kebabs.");
            return;
        }
        for (int index = 0; index < kebabList.size(); index++) {
            System.out.println((index + 1) + ") " + kebabList.get(index));
        }
    }

    private void deleteKebab() {
        listKebabs();
        System.out.print("Delete #? ");
        try {
            int kebabIndex = Integer.parseInt(inputScanner.nextLine()) - 1;
            kebabList.remove(kebabIndex);
            System.out.println("Removed.");
        } catch (Exception e) {
            System.out.println("Bad index.");
        }
    }

    private void filterByProtein() {
        System.out.print("Protein name: ");
        String targetProteinName = inputScanner.nextLine().trim().toLowerCase();
        kebabList.stream()
                .filter(kebab -> kebab.getProtein().getName().equalsIgnoreCase(targetProteinName))
                .forEach(System.out::println);
    }

    private void addCustomSauce() {
        System.out.print("Name: ");
        String sauceName = inputScanner.nextLine().trim();
        System.out.print("Shelf‑life (or Enter): ");
        String shelfLifeInput = inputScanner.nextLine().trim();
        Optional<String> shelfLife = shelfLifeInput.isEmpty() ? Optional.empty() : Optional.of(shelfLifeInput);
        Sauce customSauce = SauceFactory.create(sauceName, shelfLife);
        customSauceList.add(customSauce);
        System.out.println("Custom sauce added.");
    }

    private void deleteCustomSauce() {
        System.out.print("Name to remove: ");
        String sauceName = inputScanner.nextLine().trim();
        if (customSauceList.removeIf(sauce -> sauce.getName().equalsIgnoreCase(sauceName))) {
            System.out.println("Removed.");
        } else {
            System.out.println("Not found.");
        }
    }

    private void promptIfPresent(String label, java.util.function.Consumer<String> addIngredient) {
        System.out.print(label + " (or Enter to skip): ");
        String userInput = inputScanner.nextLine().trim();
        if (!userInput.isBlank()) {
            addIngredient.accept(userInput);
        }
    }

    private Optional<String> findShelfLifeForCustomSauce(String sauceName) {
        return customSauceList.stream()
                .filter(sauce -> sauce.getName().equalsIgnoreCase(sauceName))
                .findFirst()
                .flatMap(Sauce::getShelfLife);
    }
}
