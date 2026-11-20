package nov17_classAndLogicalOperation.week2;

import java.util.Scanner;
import javax.swing.JOptionPane; // For basic GUI input/output

// Save this file as AccountManagement.java
public class AccountManagement_Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int trackAccno = 1;

        while(true) {
            System.out.println("would you like to add an account? if yes enter 1, anything else to quit");
            int flag = scanner.nextInt();
            scanner.nextLine();
            if(flag != 1) break;
            System.out.print("Enter Account Holder Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Initial Balance: $");
            double initialBalance = scanner.nextDouble();

            BankAccount account = new BankAccount(name, initialBalance, trackAccno++);

            // 2. Terminal Input for Deposit
            System.out.print("\nEnter amount to deposit: $");
            double depositAmt = scanner.nextDouble();
            account.deposit(depositAmt);

            // 3. Terminal Input for Withdrawal
            System.out.print("Enter amount to withdraw: $");
            double withdrawAmt = scanner.nextDouble();
            account.withdraw(withdrawAmt);

            // 4. Terminal Output
            System.out.println(account.getDetails());

        }
        scanner.close();
    }
}