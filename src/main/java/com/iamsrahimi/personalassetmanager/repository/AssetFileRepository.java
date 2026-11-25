package com.iamsrahimi.personalassetmanager.repository;

import com.iamsrahimi.personalassetmanager.model.Asset;
import com.iamsrahimi.personalassetmanager.model.Electronics;
import com.iamsrahimi.personalassetmanager.model.Vehicle;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class AssetFileRepository {
    private final FileRepository<Asset> fileRepository;

    public AssetFileRepository(Path filePath) {
        fileRepository = new FileRepository<>(filePath);
    }

    public void saveAssets(List<Asset> assets) throws IOException {
        fileRepository.saveAll(assets, this::toFileLine);
    }

    public List<Asset> loadAssets() throws IOException {
        return fileRepository.loadAll(this::fromFileLine);
    }

    private String toFileLine(Asset asset) {
        if (asset instanceof Vehicle vehicle) {
            return String.join("|", "VEHICLE", clean(asset.getDescription()), asset.getDateAcquired().toString(),
                    asset.getOriginalCost().toPlainString(), clean(vehicle.getMake()), clean(vehicle.getModel()),
                    Integer.toString(vehicle.getYear()));
        }
        if (asset instanceof Electronics electronics) {
            return String.join("|", "ELECTRONICS", clean(asset.getDescription()), asset.getDateAcquired().toString(),
                    asset.getOriginalCost().toPlainString(), clean(electronics.getBrand()), clean(electronics.getDeviceType()));
        }
        throw new IllegalArgumentException("Unsupported asset type: " + asset.getClass().getSimpleName());
    }

    private Asset fromFileLine(String line) {
        String[] fields = line.split("\\|", -1);
        try {
            String type = fields[0];
            String description = fields[1];
            LocalDate dateAcquired = LocalDate.parse(fields[2]);
            BigDecimal cost = new BigDecimal(fields[3]);

            if ("VEHICLE".equals(type) && fields.length == 7) {
                return new Vehicle(description, dateAcquired, cost, fields[4], fields[5], Integer.parseInt(fields[6]));
            }
            if ("ELECTRONICS".equals(type) && fields.length == 6) {
                return new Electronics(description, dateAcquired, cost, fields[4], fields[5]);
            }
            throw new IllegalArgumentException("Unknown or incomplete asset row: " + line);
        } catch (RuntimeException exception) {
            throw new IllegalArgumentException("Could not read asset row: " + line, exception);
        }
    }

    private String clean(String value) {
        if (value.contains("|")) {
            throw new IllegalArgumentException("Text fields cannot contain the | character.");
        }
        return value;
    }
}
