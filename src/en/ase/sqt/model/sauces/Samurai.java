package src.en.ase.sqt.model.sauces;

import java.util.Optional;

public class Samurai implements Sauce {
    @Override
    public String getName() {
        return "Samurai";
    }

    @Override
    public Optional<String> getShelfLife() {
        return Optional.of("8h");
    }
}
