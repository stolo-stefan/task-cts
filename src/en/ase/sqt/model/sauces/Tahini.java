package src.en.ase.sqt.model.sauces;

import java.util.Optional;

public class Tahini implements Sauce {
    @Override
    public String getName() {
        return "Tahini";
    }

    @Override
    public Optional<String> getShelfLife() {
        return Optional.empty();
    }
}
