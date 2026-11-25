package com.iamsrahimi.personalassetmanager.app;

import com.iamsrahimi.personalassetmanager.model.Asset;
import com.iamsrahimi.personalassetmanager.model.Depreciable;
import com.iamsrahimi.personalassetmanager.model.Electronics;
import com.iamsrahimi.personalassetmanager.model.Vehicle;
import com.iamsrahimi.personalassetmanager.repository.AssetFileRepository;
import com.iamsrahimi.personalassetmanager.service.AssetManagerService;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final AssetManagerService manager = new AssetManagerService(
            new AssetFileRepository(Path.of("uploads", "assets.csv")));

    public static void main(String[] args) {
        try {
            manager.loadAssets();
            System.out.println("Loaded " + manager.getAssets().size() + " asset(s).");
        } catch (IOException | IllegalArgumentException exception) {
            System.out.println("Could not load saved assets: " + exception.getMessage());
        }

        boolean running = true;
        while (running) {
            showMenu();
            String choice = input.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> addVehicle();
                    case "2" -> addElectronics();
                    case "3" -> displayAssets(manager.getAssets());
                    case "4" -> searchAssets();
                    case "5" -> saveAssets();
                    case "6" -> running = false;
                    default -> System.out.println("Please choose a number from 1 to 6.");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid information: " + exception.getMessage());
            }
        }
        System.out.println("Goodbye!");
    }

    private static void showMenu() {
        System.out.println("\n===== PERSONAL ASSET MANAGER =====");
        System.out.println("1. Add a vehicle");
        System.out.println("2. Add electronics");
        System.out.println("3. View all assets");
        System.out.println("4. Search by description");
        System.out.println("5. Save assets");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addVehicle() {
        String description = readText("Description: ");
        LocalDate date = readDate("Date acquired (YYYY-MM-DD): ");
        BigDecimal cost = readCost("Original cost: $");
        String make = readText("Make: ");
        String model = readText("Model: ");
        int year = Integer.parseInt(readText("Vehicle year: "));
        manager.addAsset(new Vehicle(description, date, cost, make, model, year));
        System.out.println("Vehicle added.");
    }

    private static void addElectronics() {
        String description = readText("Description: ");
        LocalDate date = readDate("Date acquired (YYYY-MM-DD): ");
        BigDecimal cost = readCost("Original cost: $");
        String brand = readText("Brand: ");
        String deviceType = readText("Device type (phone, laptop, etc.): ");
        manager.addAsset(new Electronics(description, date, cost, brand, deviceType));
        System.out.println("Electronics added.");
    }

    private static void searchAssets() {
        String searchText = readText("Enter description to search for: ");
        displayAssets(manager.findByDescription(searchText));
    }

    private static void displayAssets(List<Asset> assets) {
        if (assets.isEmpty()) {
            System.out.println("No assets found.");
            return;
        }

        for (Asset asset : assets) {
            String typeDetails = "Asset";
            if (asset instanceof Vehicle vehicle) {
                typeDetails = "Vehicle: " + vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel();
            } else if (asset instanceof Electronics electronics) {
                typeDetails = "Electronics: " + electronics.getBrand() + " " + electronics.getDeviceType();
            }

            String currentValue = "Not calculated";
            if (asset instanceof Depreciable depreciable) {
                currentValue = "$" + depreciable.getCurrentValue(LocalDate.now());
            }

            System.out.println("------------------------------");
            System.out.println("Description: " + asset.getDescription());
            System.out.println(typeDetails);
            System.out.println("Acquired: " + asset.getDateAcquired());
            System.out.println("Original cost: $" + asset.getOriginalCost());
            System.out.println("Estimated current value: " + currentValue);
        }
    }

    private static void saveAssets() {
        try {
            manager.saveAssets();
            System.out.println("Assets saved.");
        } catch (IOException exception) {
            System.out.println("Could not save assets: " + exception.getMessage());
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        String text = input.nextLine().trim();
        if (text.isEmpty()) {
            throw new IllegalArgumentException("This field cannot be empty.");
        }
        if (text.contains("|")) {
            throw new IllegalArgumentException("Please do not use the | character.");
        }
        return text;
    }

    private static LocalDate readDate(String prompt) {
        System.out.print(prompt);
        return LocalDate.parse(input.nextLine().trim());
    }

    private static BigDecimal readCost(String prompt) {
        System.out.print(prompt);
        BigDecimal cost = new BigDecimal(input.nextLine().trim());
        if (cost.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }
        return cost;
    }
}
