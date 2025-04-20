package src.en.ase.sqt.persistence;

import src.en.ase.sqt.factory.SauceFactory;
import src.en.ase.sqt.model.sauces.Sauce;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileSauceRepository implements SauceRepository {
    private Path filePath;

    public FileSauceRepository(String filepath) {
        this.filePath = Paths.get(filepath);
    }

    @Override
    public List<Sauce> loadAll() {
        if (!Files.exists(filePath)) {
            return new ArrayList<>();
        }

        try {
            List<Sauce> sauces = new ArrayList<>();
            for (String line : Files.readAllLines(filePath)) {
                if (line.isBlank()) continue;
                String[] parts = line.split("\\|", 2);
                String name = parts[0];
                Optional<String> life = Optional.empty();
                if (parts.length == 2 && !parts[1].isBlank()) {
                    life = Optional.of(parts[1]);
                }
                sauces.add(SauceFactory.create(name, life));
            }
            return sauces;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load sauces from " + filePath, e);
        }
    }

    @Override
    public void saveAll(List<Sauce> sauces) {
        List<String> lines = new ArrayList<>();
        for (Sauce s : sauces) {
            String life = s.getShelfLife().orElse("");
            lines.add(s.getName() + "|" + life);
        }
        try {
            Files.write(filePath, lines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save sauces to " + filePath, e);
        }
    }
}
