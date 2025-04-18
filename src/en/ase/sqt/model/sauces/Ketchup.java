package src.en.ase.sqt.model.sauces;

import java.util.Optional;

public class Ketchup implements Sauce {
    @Override
    public String getName() {
        return "Ketchup";
    }

    @Override
    public Optional<String> getShelfLife() {
        return Optional.empty();
    }
}
