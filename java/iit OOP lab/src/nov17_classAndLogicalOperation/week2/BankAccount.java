
package nov17_classAndLogicalOperation.week2;

class BankAccount {
    // 1. Attributes (Encapsulated with private)
    private String accountHolder;
    private double balance;
    private boolean isActive;
    private int accountno;
    // 2. Constructor
    BankAccount(String name, double initialBalance,int accountno) {
        accountHolder = name;
        // Logical check: Prevent negative starting balance
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
            System.out.println("Invalid initial balance. Set to $0.0");
        }
        isActive = true;
        this.accountno = accountno;

    }

    // 3. Method with Logical Validation (Deposit)
    void deposit(double amount) {
        // Logical AND (&&): Account must be active AND amount must be positive
        if (isActive && amount > 0) {
            balance += amount;
            System.out.println("Success: Deposited $" + amount);
        } else {
            System.out.println("Error: Deposit amount must be greater than $0.");
        }
    }

    // 4. New Method with Logical Operations (Withdraw)
    int withdraw(double amount) {
        // Check multiple conditions using &&
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Success: Withdrew $" + amount);
            return 1;
        } else if (amount > balance) {
            System.out.println("Declined: Insufficient funds! Current balance: $" + balance);
            return -1;
        } else {
            System.out.println("Error: Invalid withdrawal amount.");
            return -1;
        }
    }

    // 5. Display Method (Console + Optional GUI)
    String getDetails() {
        return "Account Holder: " + accountHolder + " Account no: "+ accountno+ "\nCurrent Balance: $" + balance;
    }
}
