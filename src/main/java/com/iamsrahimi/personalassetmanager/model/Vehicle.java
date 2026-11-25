package com.iamsrahimi.personalassetmanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset implements Depreciable {
    private String make;
    private String model;
    private int year;

    public Vehicle(String description, LocalDate dateAcquired, BigDecimal originalCost,
                   String make, String model, int year) {
        super(description, dateAcquired, originalCost);
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public BigDecimal getAnnualDepreciationRate() {
        return new BigDecimal("0.10");
    }
}
