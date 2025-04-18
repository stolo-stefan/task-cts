package src.en.ase.sqt.model.sauces;

import java.util.Optional;

public class Tzatziki implements Sauce {
    @Override
    public String getName() {
        return "Tzatziki";
    }

    @Override
    public Optional<String> getShelfLife() {
        return Optional.of("12h");
    }
}
