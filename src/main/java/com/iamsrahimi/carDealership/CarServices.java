package com.iamsrahimi.carDealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static com.iamsrahimi.carDealership.Main.*;

public class CarServices {
    private static Scanner input = new Scanner(System.in);
    private static Car car;

    public static void addCar() {

        System.out.println("Please enter the name of the car: ");
        String name =  input.nextLine();
        System.out.println("Please enter the color of the car: ");
        String color =  input.nextLine();
        System.out.println("Please enter the model of the car: ");
        String model =  input.nextLine();
        System.out.println("Please enter the type of the car (e.g SUV, sedan: ");
        String type =  input.nextLine();
        System.out.println("Please enter the year of the car: ");
        int year =  input.nextInt();
        input.nextLine(); // to clear the remaining
        System.out.println("Please enter the mileage of the car: ");
        int mileage =  input.nextInt();
        input.nextLine();
        System.out.println("Please enter the price of the car: ");
        double price = input.nextDouble();
        input.nextLine(); // to clear the remaining

        car = new Car(name, model, color, price, year, mileage, type);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("uploads/car-dealarship.csv", true));
            bw.write(Car.convertToCsvFormat(car));
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        }


    }

    public static void showCars() {
        tableHeader();
        for  (Car car : Main.cars) {
            System.out.println(car.toString());
        }
        optionMenu();

    }

    public static void optionMenu() {
        System.out.println("============================================");
        System.out.println("Enter: [1] DELETE CAR, [2] HOME, [0] EXIT");
        int choice = input.nextInt(); input.nextLine();
        switch (choice) {
            case 1:
                deleteCar();
                break;
                case 0:
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Invalid choice");
                        optionMenu();
                        break;
        }
    }

    public static void deleteCar() {
        System.out.print("Enter the ID of the car to delete: ");
        long id = input.nextLong();
        System.out.println("Length:" + Main.cars.size());
        boolean removed = Main.cars.removeIf(car -> car.getId() == id);
        System.out.println("Length After:" + Main.cars.size());
        if (!removed) {
            System.out.println("No car found with that ID.");
            optionMenu();
            return;
        }

        saveCarsToCsv();
        System.out.println("Car deleted successfully.");
        Main.homeMenu();
    }

    private static void saveCarsToCsv() {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("uploads/car-dealarship.csv"));
            bw.write("id|name|model|year|color|type|mileage|price");
            bw.newLine();

            for (Car car : Main.cars) {
                bw.write(Car.convertToCsvFormat(car));
                bw.newLine();
            }
            bw.close();
        }  catch (IOException e) {
            System.out.println("Could not update the CSV file: " + e.getMessage());
        }


    }

    public static void tableHeader() {
        String format = "%-14s | %-20.20s | %-15.15s | %4s | %-10.10s | %-12.12s | %9s | %11s%n";
        System.out.printf(format,
                "ID", "Name", "Model", "Year", "Color", "Type", "Mileage", "Price");
    }

}
