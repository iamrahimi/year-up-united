package com.iamsrahimi.carDealership;

public abstract class Contract {

    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    private  Car vehicle;


    public Contract(String dateOfContract, String customerName, String customerEmail, Car vehicle, double totalPrice, double monthlyPayment) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public Contract(String dateOfContract, String customerName, String customerEmail, Car vehicle) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public Car getVehicle() {
        return vehicle;
    }

    public void setVehicle(Car vehicle) {
        this.vehicle = vehicle;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();



}
