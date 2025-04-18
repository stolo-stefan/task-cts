package src.en.ase.sqt.main;

import src.en.ase.sqt.builder.KebabBuilder;
import src.en.ase.sqt.model.Kebab;
import src.en.ase.sqt.model.carbohydrates.Potato;
import src.en.ase.sqt.model.fibers.Carrot;
import src.en.ase.sqt.model.proteins.Chicken;
import src.en.ase.sqt.model.sauces.Ketchup;
import src.en.ase.sqt.model.sauces.Samurai;
import src.en.ase.sqt.model.sauces.Tahini;

public class Main {
    public static void main(String[] args){

        KebabBuilder misterBossMan = new KebabBuilder();
        Kebab myKebab = misterBossMan.addProtein(new Chicken()).addCarbohydrate(new Potato())
                .addSauce(new Tahini()).addSauce(new Ketchup()).addSauce(new Samurai())
                .addFiber(new Carrot())
                .build();
        System.out.println(myKebab);
        myKebab.printSauceShelfLife();
    }
}
