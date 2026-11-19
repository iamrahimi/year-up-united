package com.iamsrahimi.carDealership;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;


public class ContractSalesManger {
    private final Path contractsFile;
    private static Scanner input = new Scanner(System.in);

    public ContractSalesManger() {
        this(Paths.get("uploads/contracts.csv"));
    }

    public ContractSalesManger(Path contractsFile) {
        this.contractsFile = contractsFile;
    }

    public static void sellLeaseCar() {
        System.out.println("welcome to sell lease car");
        System.out.println("Please choose from the following options:");
        System.out.println("Choose [1] to Lease, [2] to Sale");

        int choice = input.nextInt(); input.nextLine();
        switch (choice) {
            case 1:
                leaseVehicle();
                break;
            case 2:
                saleVehicle();
                break;
                default:
                    System.out.println("invalid choice");
                    sellLeaseCar();
                    break;
        }
    }

    public static void leaseVehicle() {

    }

    public static void saleVehicle() {
        CarServices.showCars();
        String dateOfSale = LocalDate.now().toString();
        System.out.println("Please enter the customer name: ");
        String customerName = input.nextLine();
        System.out.println("Please enter the customer Email:");
        String customerEmail = input.nextLine();
        System.out.println("Please enter the VIN/ID of car");
        String customerVIN = input.nextLine();
        System.out.println("Please enter the total price:");
        double price = input.nextDouble(); input.nextLine();
        System.out.println("Please enter the monthly payment");
        int monthlyPayment = input.nextInt(); input.nextLine();

        Car saleCar = findCarById(Long.parseLong(customerVIN));
        System.out.println("I Am the Car: " + saleCar.getName());
        SalesContract sc = new SalesContract(dateOfSale, customerName, customerEmail, saleCar, true);
    }

    private static Car findCarById(Long id) {
        Car foundCar = null;
        System.out.println(id + " car found");
        for (Car car : Main.cars) {
            if (car.getId() == id) {
                foundCar = car;
                break;
            }
        }

        if (foundCar != null) {
            System.out.println("Car found: " + foundCar);
        } else {
            System.out.println("No car found with that ID.");
        }

        return foundCar;
    }


    public void saveContract(Contract contract) throws IOException {
        Path parent = contractsFile.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        String row = makeRow(contract);
        try (BufferedWriter writer = Files.newBufferedWriter(
                contractsFile,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            writer.write(row);
            writer.newLine();
        }
    }

    private String makeRow(Contract contract) {
        Car vehicle = contract.getVehicle();
        StringBuilder row = new StringBuilder();

        if (contract instanceof SalesContract) {
            SalesContract sale = (SalesContract) contract;
            add(row, "SALE");
            addCommonFields(row, contract, vehicle);
            add(row, money(sale.getSalesTaxAmount()));
            add(row, money(sale.getRecordingFee()));
            add(row, money(sale.getProcessingFee()));
            add(row, money(sale.getTotalPrice()));
            add(row, sale.isFinanced() ? "YES" : "NO");
            add(row, money(sale.getMonthlyPayment()));
        } else if (contract instanceof LeaseContract) {
            LeaseContract lease = (LeaseContract) contract;
            add(row, "LEASE");
            addCommonFields(row, contract, vehicle);
            add(row, money(lease.getExpectedEndingValue()));
            add(row, money(lease.getLeaseFee()));
            add(row, money(lease.getTotalPrice()));
            add(row, money(lease.getMonthlyPayment()));
        } else {
            throw new IllegalArgumentException("Unsupported contract type: " + contract.getClass());
        }

        // The add helper leaves a delimiter after each value; remove the final one.
        row.setLength(row.length() - 1);
        return row.toString();
    }

    private void addCommonFields(StringBuilder row, Contract contract, Car vehicle) {
        add(row, contract.getDateOfContract());
        add(row, contract.getCustomerName());
        add(row, contract.getCustomerEmail());
        add(row, String.valueOf(vehicle.getYear()));
        add(row, vehicle.getModel());
        add(row, vehicle.getModel());
        add(row, vehicle.getType());
        add(row, vehicle.getColor());
        add(row, String.valueOf(vehicle.getMileage()));
        add(row, money(vehicle.getPrice()));
    }

    private void add(StringBuilder row, String value) {
        // Pipes and line breaks would corrupt the file's row structure.
        String safeValue = value == null ? "" : value.replace('|', '/').replace('\n', ' ').replace('\r', ' ');
        row.append(safeValue).append('|');
    }

    private String money(double amount) {
        return String.format(Locale.US, "%.2f", amount);
    }
}
