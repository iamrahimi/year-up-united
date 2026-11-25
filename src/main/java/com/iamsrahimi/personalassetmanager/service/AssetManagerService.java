package com.iamsrahimi.personalassetmanager.service;

import com.iamsrahimi.personalassetmanager.model.Asset;
import com.iamsrahimi.personalassetmanager.repository.AssetFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssetManagerService {
    private final List<Asset> assets = new ArrayList<>();
    private final AssetFileRepository repository;

    public AssetManagerService(AssetFileRepository repository) {
        this.repository = repository;
    }

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public List<Asset> getAssets() {
        return new ArrayList<>(assets);
    }

    public List<Asset> findByDescription(String searchText) {
        List<Asset> matches = new ArrayList<>();
        for (Asset asset : assets) {
            if (asset.getDescription().toLowerCase().contains(searchText.toLowerCase())) {
                matches.add(asset);
            }
        }
        return matches;
    }

    public void loadAssets() throws IOException {
        assets.clear();
        assets.addAll(repository.loadAssets());
    }

    public void saveAssets() throws IOException {
        repository.saveAssets(assets);
    }
}
