package com.iamsrahimi.FinanceApplication;

import java.util.ArrayList;

public class ValuableDemo {
    public static void main(String[] args) {
        ArrayList<Valuable> items = new ArrayList<>();

        items.add(new Jewelry("Gold ring", 850.00, 18));
        items.add(new Gold("Gold bar", 2400.00, 20));
        items.add(new House("Family house", 425000.00, 2008, 2100, 4));
        items.add(new BankAccount("Rahim", "BA-1001", 3200.00));
        items.add(new CreditCard("Rahim", "CC-2001", 450.00));

        for (Valuable item : items) {
            System.out.printf("Value: $%.2f%n", item.getValue());
        }
    }
}
