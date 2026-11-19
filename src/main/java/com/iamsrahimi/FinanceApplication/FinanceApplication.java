package com.iamsrahimi.FinanceApplication;
import java.math.BigDecimal;

public class FinanceApplication {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Pam", "123", 12500.0);
        Valuable account2 = new BankAccount("Gary", "456", 1500.0);

        account1.deposit(100); // Works if deposit accepts a double

// account2.deposit(100); // Compile error: Valuable doesn't declare deposit()
    }
}
