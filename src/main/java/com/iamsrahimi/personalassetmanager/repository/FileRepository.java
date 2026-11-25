package com.iamsrahimi.personalassetmanager.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileRepository<T> {
    private final Path filePath;

    public FileRepository(Path filePath) {
        this.filePath = filePath;
    }

    public void saveAll(List<T> items, Function<T, String> formatter) throws IOException {
        Path parent = filePath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (T item : items) {
                writer.write(formatter.apply(item));
                writer.newLine();
            }
        }
    }

    public List<T> loadAll(Function<String, T> parser) throws IOException {
        List<T> items = new ArrayList<>();
        if (!Files.exists(filePath)) {
            return items;
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    items.add(parser.apply(line));
                }
            }
        }
        return items;
    }
}
