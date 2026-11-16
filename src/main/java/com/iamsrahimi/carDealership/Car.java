package com.iamsrahimi.carDealership;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Car {
    private String name;
    private String model;
    private String color;
    private double price;
    private int year;
    private int mileage;
    private String type;
    private long id;

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car() {
    }

    public Car(String name, String model, String color, double price, int year, int mileage, String type) {
        this.name = name;
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
        this.mileage = mileage;
        this.type = type;
    }

    public Car(Long id, String name, String model, String color, double price, int year, int mileage, String type) {
        this.name = name;
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
        this.mileage = mileage;
        this.type = type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String format =
                "%-14s | %-20.20s | %-15.15s | %4s | %-10.10s | %-12.12s | %9s | %11s";

        return String.format(format,
                getId(),
                getName(),
                getModel(),
                getYear(),
                getColor(),
                getType(),
                String.format("%,d", getMileage()),
                String.format("$%,.2f", getPrice()));
    }

    public static String convertToCsvFormat(Car car) {LocalDateTime now = LocalDateTime.now();

        String id = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        String csvFormat =  id +"|"+ car.getName() +
                                "|" + car.getModel() +
                                "|" + car.getYear() +
                                "|" + car.getColor() +
                                "|" + car.getType() +
                                "|" + car.getMileage() +
                                "|" + car.getPrice();

        return csvFormat;
    }
}
