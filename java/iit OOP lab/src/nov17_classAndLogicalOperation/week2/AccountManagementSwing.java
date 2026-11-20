package nov17_classAndLogicalOperation.week2;

import javax.swing.*;
import java.awt.GridLayout;

public class AccountManagementSwing {
    // Object reference accessible by button actions
    static int trackAccno = 1;
    private static BankAccount account;

    public static void main(String[] args) {
        // 1. Create the main window (JFrame)
        JFrame frame = new JFrame("Bank Account Manager");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(9, 1, 5, 5)); // Simple 9-row vertical layout

        // 2. UI Input Components
        JTextField nameField = new JTextField();
        JTextField initBalanceField = new JTextField();
        JButton createBtn = new JButton("1. Create Account");

        JTextField amountField = new JTextField();
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");

        // 3. UI Output Labels
        JLabel statusLabel = new JLabel("Status: Enter name and balance to start.");
        JLabel detailsLabel = new JLabel("Account: None");

        // 4. Add components to window
        frame.add(new JLabel("Account Holder Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Initial Balance ($):"));
        frame.add(initBalanceField);
        frame.add(createBtn);

        frame.add(new JLabel("Transaction Amount ($):"));
        frame.add(amountField);

        // Put Deposit and Withdraw buttons side-by-side
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);
        frame.add(buttonPanel);
        // Output panel
        JPanel outputPanel = new JPanel(new GridLayout(2, 1));
        outputPanel.add(statusLabel);
        outputPanel.add(detailsLabel);
        frame.add(outputPanel);

        // 5. Button Click Actions (Events)
        createBtn.addActionListener(e -> {
            String name = nameField.getText();
            double startBal = Double.parseDouble(initBalanceField.getText());
            // Logical AND (&&) + NOT (!)
            if (!name.isEmpty() && startBal >= 0) {
                account = new BankAccount(name, startBal,trackAccno);
                trackAccno++;
                statusLabel.setText("Status: Account Created!");
                detailsLabel.setText(account.getDetails());
            } else {
                statusLabel.setText("Error: Enter a valid name and balance.");
            }
        });

        depositBtn.addActionListener(e -> {
            if (account != null) {
                double amt = Double.parseDouble(amountField.getText());
               statusLabel.setText("Status: Deposit successful.");
                detailsLabel.setText(account.getDetails());
            } else {
                statusLabel.setText("Error: Create an account first!");
            }
        });

        withdrawBtn.addActionListener(e -> {
            if (account != null) {
                double amt = Double.parseDouble(amountField.getText());
                if( account.withdraw(amt) < 0){
                    statusLabel.setText("invalid  amount or taka nai");
                }
                else {
                    statusLabel.setText("Status: Withdrawal successful.");
                    detailsLabel.setText(account.getDetails());
                }
            } else {
                statusLabel.setText("Error: Create an account first!");
            }
        });

        // 6. Make the window visible
        frame.setVisible(true);
    }
}