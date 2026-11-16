package bank_nov10;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;

class BankAccount {
    // Attributes (Instance Variables)
    private String accountHolder;
    private double balance;
    // Constructor: Initializes a new account object
    BankAccount(String name, double initialBalance) {
        this.accountHolder = name;
        this.balance = initialBalance;
    }
    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + "deposited $" + amount);
    }
    // Method to display balance details
    void displayDetails() {
        System.out.println("Account Holder:" + accountHolder);
        System.out.println("Current Balance: $" + balance);
        System.out.println("---------------------------");
    }
    void takeOutmoney(){
        System.out.println("the account that the money will be taken out from is "+ this.accountHolder);
        System.out.println("enter the amount you would like to take out");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextFloat();

        if(amount<0) {
            amount = amount*(-1);
            balance = balance - amount;
        }
        else if(amount>balance) {
            System.out.println("you can only take out " + balance + " ,after that you balance would be 0");
            amount = balance;
            balance = 0;
        }
            else {
            balance = balance - amount;
        }

        System.out.println("the amount "+amount+" has been deducted from balance. new balance is: " +balance);
        System.out.println("---------------------------");
    }
}