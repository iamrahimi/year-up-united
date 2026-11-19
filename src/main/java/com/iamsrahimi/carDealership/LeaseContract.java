package com.iamsrahimi.carDealership;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Car vehicle) {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * 0.50;
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    public double getExpectedEndingValue() { return expectedEndingValue; }
    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() { return leaseFee; }
    public void setLeaseFee(double leaseFee) { this.leaseFee = leaseFee; }

    @Override
    public double getTotalPrice() {
        return expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return SalesContract.calculatePayment(getTotalPrice(), 0.04, 36);
    }
}
