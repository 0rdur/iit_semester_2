package nov17_classAndLogicalOperation.week2;

import javax.swing.JOptionPane; // For basic GUI input/output

// Save this file as AccountManagement_UI.java
public class AccountManagement_UI {
    public static void main(String[] args) {
        // 1. UI Input Box for Object Creation
        String name = JOptionPane.showInputDialog("Enter Account Holder Name:");
        
        String initBalStr = JOptionPane.showInputDialog("Enter Initial Balance ($):");
        double initialBalance = Double.parseDouble(initBalStr);
        int trackAccno = 1;
        BankAccount account = new BankAccount(name, initialBalance,trackAccno++);

        // 2. UI Input Box for Deposit
        String depositStr = JOptionPane.showInputDialog("Enter amount to deposit ($):");
        double depositAmt = Double.parseDouble(depositStr);
        account.deposit(depositAmt);

        // 3. UI Input Box for Withdrawal
        String withdrawStr = JOptionPane.showInputDialog("Enter amount to withdraw ($):");
        double withdrawAmt = Double.parseDouble(withdrawStr);
        account.withdraw(withdrawAmt);

        // 4. UI Output Box
        JOptionPane.showMessageDialog(null, account.getDetails(), "Account Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}