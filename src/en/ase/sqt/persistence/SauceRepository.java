package src.en.ase.sqt.persistence;

import src.en.ase.sqt.model.sauces.Sauce;

import java.util.List;

public interface SauceRepository {
    List<Sauce> loadAll();

    void saveAll(List<Sauce> sauces);
}
