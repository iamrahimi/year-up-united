package com.iamsrahimi.assetsManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.Locale;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int age = Math.max(0, Year.now().getValue() - year);
        BigDecimal value;

        if (age > 10) {
            value = new BigDecimal("1000.00");
        } else {
            BigDecimal yearlyRate;
            if (age <= 3) {
                yearlyRate = new BigDecimal("0.03");
            } else if (age <= 6) {
                yearlyRate = new BigDecimal("0.06");
            } else {
                yearlyRate = new BigDecimal("0.08");
            }

            // Apply the yearly reduction to the original cost (simple depreciation).
            BigDecimal totalReductionRate = yearlyRate.multiply(BigDecimal.valueOf(age));
            BigDecimal reduction = getOriginalCost().multiply(totalReductionRate);
            value = getOriginalCost().subtract(reduction).max(BigDecimal.ZERO);
        }

        String lowerMakeModel = makeModel.toLowerCase(Locale.ROOT);
        boolean protectedMake = lowerMakeModel.contains("honda") || lowerMakeModel.contains("toyota");
        if (odometer > 100_000 && !protectedMake) {
            value = value.multiply(new BigDecimal("0.75"));
        }

        return value.max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
    }
}
