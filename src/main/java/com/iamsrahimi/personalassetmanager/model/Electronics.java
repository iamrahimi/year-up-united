package com.iamsrahimi.personalassetmanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Electronics extends Asset implements Depreciable {
    private String brand;
    private String deviceType;

    public Electronics(String description, LocalDate dateAcquired, BigDecimal originalCost,
                       String brand, String deviceType) {
        super(description, dateAcquired, originalCost);
        this.brand = brand;
        this.deviceType = deviceType;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

    @Override
    public BigDecimal getAnnualDepreciationRate() {
        return new BigDecimal("0.20");
    }
}
