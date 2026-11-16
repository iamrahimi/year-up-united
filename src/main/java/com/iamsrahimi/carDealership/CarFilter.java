package com.iamsrahimi.carDealership;

import java.util.Scanner;

public class CarFilter {

    private static Scanner input = new Scanner(System.in);
    private static Car car;

    public static void filterCarBy() {
        System.out.println("Filter car by: ");
        System.out.println("Filter By: [1] Price, [2] Mileage, [3] Year, [4] Make/Model, [5] Color, [0] RETURN HOME");

        int choice = input.nextInt(); input.nextLine();
        switch (choice) {

            case 0:
                Main.homeMenu();
                break;

            case 1:
                filterByPrice();
                break;

            case 2:
                filterByMileage();
                break;

            case 3:
                filterByYear();
                break;

            case 4:
                filterByMakeModel();
                break;

            case 5:
                filterByColor();
                break;

            default:
                System.out.println("Invalid choice");
                filterCarBy();
                break;
        }

        filterCarBy();
    }

    private static void filterByPrice() {
        System.out.println("Filter By Price: ");
        System.out.println("Please enter start price: ");
        double startPrice = input.nextDouble(); input.nextLine();
        System.out.println("Please enter end price: ");
        double endPrice = input.nextDouble(); input.nextLine();

        CarServices.tableHeader();
        for (Car car: Main.cars) {
            if (car.getPrice() >= startPrice && car.getPrice() <= endPrice) {
                System.out.println(car.toString());
            }
        }
    }

    private static void filterByMileage() {
        System.out.println("Filter By Mileage: ");
        System.out.println("Please enter start mileage: ");
        int startMileage = input.nextInt(); input.nextLine();
        System.out.println("Please enter end mileage: ");
        int endMileage = input.nextInt(); input.nextLine();
        CarServices.tableHeader();
        for (Car car: Main.cars) {
            if (car.getMileage() >= startMileage && car.getMileage() <= endMileage) {
                System.out.println(car.toString());
            }
        }
    }

    private static void filterByYear() {
        System.out.println("Filter By Year: ");
        System.out.println("Please enter start year: ");
        int startYear = input.nextInt(); input.nextLine();
        System.out.println("Please enter end year: ");
        int endYear = input.nextInt(); input.nextLine();
        CarServices.tableHeader();
        for (Car car: Main.cars) {
            if (car.getYear() >= startYear && car.getYear() <= endYear) {
                System.out.println(car.toString());
            }
        }
    }

    private static void filterByMakeModel() {
        System.out.println("Filter By Make Model: ");
        System.out.println("Please enter make model: ");
        String makeModel = input.nextLine();
        CarServices.tableHeader();
        for (Car car: Main.cars) {
            if(car.getModel().equals(makeModel)) {
                System.out.println(car.toString());
            }
        }
    }


    private static void filterByColor() {
        System.out.println("Filter By Color: ");
        System.out.println("Please enter color: ");
        String color = input.nextLine();
        CarServices.tableHeader();
        for (Car car: Main.cars) {
            if(car.getColor().equals(color)) {
                System.out.println(car.toString());
            }
        }
    }
}
