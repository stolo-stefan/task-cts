package src.en.ase.sqt.model;

import src.en.ase.sqt.model.carbohydrates.Carbohydrate;
import src.en.ase.sqt.model.fibers.Fiber;
import src.en.ase.sqt.model.healthy.Healthy;
import src.en.ase.sqt.model.pickles.Pickle;
import src.en.ase.sqt.model.proteins.Protein;
import src.en.ase.sqt.model.sauces.Sauce;
import src.en.ase.sqt.model.wraps.Wrap;

import java.util.List;

public class Kebab {
    private final Protein protein;
    private final Carbohydrate carbohydrate;
    private final Pickle pickle;
    private final Wrap wrap;
    private final Fiber fiber;
    private final Healthy healthy;
    private final List<Sauce> sauces;

    public Kebab(Protein protein, Carbohydrate carbohydrate, Pickle pickle, Wrap wrap,
                 Fiber fiber, Healthy healthy, List<Sauce> sauces) {
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.pickle = pickle;
        this.wrap = wrap;
        this.fiber = fiber;
        this.healthy = healthy;
        this.sauces = sauces;
    }

    public void printSauceShelfLife() {
        System.out.println("Sauce Shelf Life Info:");
        for (Sauce sauce : sauces) {
            sauce.getShelfLife().ifPresent(shelfLife ->
                    System.out.println(sauce.getName() + ": " + shelfLife));
        }
    }

    public Protein getProtein() {
        return protein;
    }
    public Carbohydrate getCarbohydrate() {
        return carbohydrate;
    }
    public Pickle getPickle() {
        return pickle;
    }
    public Wrap getWrap() {
        return wrap;
    }
    public Fiber getFiber() {
        return fiber;
    }
    public Healthy getHealthy() {
        return healthy;
    }
    public List<Sauce> getSauces() {
        return sauces;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Kebab{");
        sb.append("protein=").append(protein.getName());
        sb.append(", carbohydrate=").append(carbohydrate.getName());

        if (pickle != null)
            sb.append(", pickle=").append(pickle.getName());
        if (wrap != null)
            sb.append(", wrap=").append(wrap.getName());
        if (fiber != null)
            sb.append(", fiber=").append(fiber.getName());
        if (healthy != null)
            sb.append(", healthy=").append(healthy.getName());

        if (sauces != null && !sauces.isEmpty()) {
            sb.append(", sauces=[");
            for (int i = 0; i < sauces.size(); i++) {
                sb.append(sauces.get(i).getName());
                if (i < sauces.size() - 1) sb.append(", ");
            }
            sb.append("]");
        }

        sb.append('}');
        return sb.toString();
    }
}

