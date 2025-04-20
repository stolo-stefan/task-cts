package src.en.ase.sqt.factory;

import src.en.ase.sqt.model.sauces.*;

import java.util.Optional;

public class SauceFactory {
    private SauceFactory() {}

    public static Sauce create(String name, Optional<String> shelfLife) {
        switch(name.toLowerCase()) {
            case "tahini"   : return new Tahini();
            case "samurai"  : return new Samurai();
            case "tzatziki" : return new Tzatziki();
            case "ketchup"  : return new Ketchup();
            default         :
                return new Sauce() {
                    public String getName()       { return name; }
                    public Optional<String> getShelfLife() { return shelfLife; }
                };
        }
    }
}
