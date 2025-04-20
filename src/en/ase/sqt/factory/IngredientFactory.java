package src.en.ase.sqt.factory;

import src.en.ase.sqt.model.carbohydrates.*;
import src.en.ase.sqt.model.fibers.*;
import src.en.ase.sqt.model.healthy.*;
import src.en.ase.sqt.model.pickles.*;
import src.en.ase.sqt.model.proteins.*;
import src.en.ase.sqt.model.sauces.*;
import src.en.ase.sqt.model.wraps.*;

import java.util.Optional;

public class IngredientFactory {

    public static Protein createProtein(String name) {
        return switch (name.toLowerCase()) {
            case "chicken" -> new Chicken();
            case "lamb" -> new Lamb();
            case "falafel" -> new Falafel();
            default -> throw new IllegalArgumentException("Unknown protein: " + name);
        };
    }

    public static Carbohydrate createCarbohydrate(String name) {
        return switch (name.toLowerCase()) {
            case "potatoes" -> new Potato();
            case "rice" -> new Rice();
            default -> throw new IllegalArgumentException("Unknown carbohydrate: " + name);
        };
    }

    public static Pickle createPickle(String name) {
        return switch (name.toLowerCase()) {
            case "cucumbers" -> new Cucumber();
            case "onions" -> new Onion();
            default -> throw new IllegalArgumentException("Unknown pickle: " + name);
        };
    }

    public static Wrap createWrap(String name) {
        return switch (name.toLowerCase()) {
            case "salad" -> new Salad();
            case "pita" -> new Pita();
            default -> throw new IllegalArgumentException("Unknown wrap: " + name);
        };
    }

    public static Fiber createFiber(String name) {
        return switch (name.toLowerCase()) {
            case "cabbage" -> new Cabbage();
            case "tomatoes" -> new Tomato();
            case "carrots" -> new Carrot();
            default -> throw new IllegalArgumentException("Unknown fiber: " + name);
        };
    }

    public static Healthy createHealthy(String name) {
        return switch (name.toLowerCase()) {
            case "spinach" -> new Spinach();
            case "radish" -> new Radish();
            default -> throw new IllegalArgumentException("Unknown healthy ingredient: " + name);
        };
    }

    public static Sauce createSauce(String name) {
        return switch (name.toLowerCase()) {
            case "tahini" -> new Tahini();
            case "samurai" -> new Samurai();
            case "tzatziki" -> new Tzatziki();
            case "ketchup" -> new Ketchup();
            default -> throw new IllegalArgumentException("Unknown sauce: " + name);
        };
    }

    public static Sauce createCustomSauce(String name, String shelfLife) {
        return new Sauce() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public Optional<String> getShelfLife() {
                return shelfLife.isBlank() ? Optional.empty() : Optional.of(shelfLife);
            }
        };
    }
}
