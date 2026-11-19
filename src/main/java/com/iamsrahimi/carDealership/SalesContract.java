package com.iamsrahimi.carDealership;
import com.iamsrahimi.carDealership.Contract;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financed;

    public SalesContract(String date, String customerName, String customerEmail,
                         Car vehicle, boolean financed) {
        super(date, customerName, customerEmail, vehicle);
        this.salesTaxAmount = vehicle.getPrice() * 0.05;
        this.recordingFee = 100.00;
        this.processingFee = vehicle.getPrice() < 10000.00 ? 295.00 : 495.00;
        this.financed = financed;
    }

    public double getSalesTaxAmount() { return salesTaxAmount; }
    public void setSalesTaxAmount(double salesTaxAmount) { this.salesTaxAmount = salesTaxAmount; }

    public double getRecordingFee() { return recordingFee; }
    public void setRecordingFee(double recordingFee) { this.recordingFee = recordingFee; }

    public double getProcessingFee() { return processingFee; }
    public void setProcessingFee(double processingFee) { this.processingFee = processingFee; }

    public boolean isFinanced() { return financed; }
    public void setFinanced(boolean financed) { this.financed = financed; }

    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financed) {
            return 0.0;
        }
        double annualRate = getVehicle().getPrice() >= 10000.00 ? 0.0425 : 0.0525;
        int months = getVehicle().getPrice() >= 10000.00 ? 48 : 24;
        return calculatePayment(getTotalPrice(), annualRate, months);
    }

    static double calculatePayment(double principal, double annualRate, int months) {
        double monthlyRate = annualRate / 12.0;
        return principal * monthlyRate / (1.0 - Math.pow(1.0 + monthlyRate, -months));
    }
}