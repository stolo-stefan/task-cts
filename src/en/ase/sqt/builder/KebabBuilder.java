package src.en.ase.sqt.builder;

import src.en.ase.sqt.model.Kebab;
import src.en.ase.sqt.model.carbohydrates.Carbohydrate;
import src.en.ase.sqt.model.fibers.Fiber;
import src.en.ase.sqt.model.healthy.Healthy;
import src.en.ase.sqt.model.pickles.Pickle;
import src.en.ase.sqt.model.proteins.Protein;
import src.en.ase.sqt.model.sauces.Sauce;
import src.en.ase.sqt.model.wraps.Wrap;
import java.util.ArrayList;
import java.util.List;

public class KebabBuilder {
    private Protein protein;
    private Carbohydrate carbohydrate;
    private Pickle pickle;
    private Wrap wrap;
    private Fiber fiber;
    private Healthy healthy;
    private final List<Sauce> sauces = new ArrayList<>();

    public KebabBuilder addProtein(Protein protein) {
        if (this.protein != null) {
            throw new IllegalStateException("Only one protein can be added.");
        }
        this.protein = protein;
        return this;
    }

    public KebabBuilder addCarbohydrate(Carbohydrate carbohydrate) {
        if (this.carbohydrate != null) {
            throw new IllegalStateException("Only one carbohydrate can be added.");
        }
        this.carbohydrate = carbohydrate;
        return this;
    }

    public KebabBuilder addPickle(Pickle pickle) {
        this.pickle = pickle;
        return this;
    }

    public KebabBuilder addWrap(Wrap wrap) {
        this.wrap = wrap;
        return this;
    }

    public KebabBuilder addFiber(Fiber fiber) {
        this.fiber = fiber;
        return this;
    }

    public KebabBuilder addHealthy(Healthy healthy) {
        this.healthy = healthy;
        return this;
    }

    public KebabBuilder addSauce(Sauce sauce) {
        if (this.protein == null) {
            throw new IllegalStateException("You must add protein before adding sauces.");
        }
        if (this.sauces.size() >= 3) {
            throw new IllegalStateException("You can add a maximum of 3 sauces.");
        }
        this.sauces.add(sauce);
        return this;
    }

    public Kebab build() {
        if (this.protein == null || this.carbohydrate == null) {
            throw new IllegalStateException("A kebab must have at least one protein and one carbohydrate.");
        }
        return new Kebab(protein, carbohydrate, pickle, wrap, fiber, healthy, sauces);
    }
}

