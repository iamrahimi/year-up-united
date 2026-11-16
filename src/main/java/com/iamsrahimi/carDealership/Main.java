package com.iamsrahimi.carDealership;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    private static Scanner input = new Scanner(System.in);
    public static ArrayList<Car> cars = new ArrayList<Car>();

    public static void main(String[] args) {
        cars.clear();
        try {
            importCsvToArrayList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        homeMenu();

    }

    public static void homeMenu() {
        System.out.println("Welcome to Car Dealership!");
        System.out.println("1. Show Cars");
        System.out.println("2. Add Car");
        System.out.println("3. Find Car By");
        System.out.println("0. Exit");
        System.out.println("Choose your option [0-3]:");

        int choice = input.nextInt(); input.nextLine();
        switch (choice) {
            case 0:
                exit(0);
                break;

            case 1:
                CarServices.showCars();
                break;

            case 2:
                addNewCar();
                break;

                case 3:
                    CarFilter.filterCarBy();
                    break;

            default:
                System.out.println("Invalid choice");
                homeMenu();
                break;
        }
    }

    public static void addNewCar() {
        boolean check = false;

        do {
            CarServices.addCar();
            System.out.print("Do you want to add another car? [y/n]: ");
            String name = input.nextLine();
            if (name.equals("y")) {
                check = true;
            }else {
                check = false;
            }
        } while (check);
    }



    public static void importCsvToArrayList() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("uploads/car-dealarship.csv"));
            String line =  br.readLine();
            while((line = br.readLine()) != null){
                String[] row = line.split("\\|");
                Long id = Long.parseLong(row[0]);
                double price = Double.parseDouble(row[7]);
                int year = Integer.parseInt(row[3]);
                int mileage = Integer.parseInt(row[6]);

                Car  car = new Car(id, row[1] , row[2], row[3],price, year, mileage, row[5]);
                cars.add(car);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
