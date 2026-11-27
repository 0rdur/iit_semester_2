package nov24_exam;


class BankAccount {
    // 1. Attributes (Encapsulated with private)
    private String accountHolder;
    private double balance;
    private String  accountno;
    private String  gender;
    private float transLimit;

    // 2. Constructor
    BankAccount(String name,String  accountno,String gender, double initialBalance) {
        this.accountHolder = name;
        this.accountno = accountno;
        // Logical check: Prevent negative starting balance
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else if(initialBalance <100){
            balance = 0;
            System.out.println("Invalid initial balance. Set to $0.0");
        }
        this.gender = gender;
        if(this.gender.equals("Female")) {
            this.transLimit = 5000;
        }
        else if(this.gender.equals("Male")) {
            this.transLimit = 4500;
        }
        else {
            System.out.println("give a valid gender");
            this.gender = "INVALID";
        }

    }

    // 3. Method with Logical Validation (Deposit)
    void deposit(double amount ) {
            if (amount > 0 && amount<20000) {
                balance += amount;
                System.out.println("Success: Deposited $" + amount+ " in the account: "+this.accountHolder+ "\n");
            } else {
                System.out.println("Error: Deposit amount must be greater than $0 and less than $20000");
            }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance && this.transLimit>amount) {
                balance -= amount;
                System.out.println("Success: Withdrew $" + amount +" from the account: "+this.accountHolder+ "\n");
        }else if (amount > balance) {
            System.out.println("Declined: Insufficient funds! Current balance: $" + balance+ "\n");
        } else if (amount >this.transLimit) {
            System.out.println("Declined: this withdrawal amount is more than the transaction limit: $"+this.transLimit+ "\n");

        } else {
            System.out.println("Error: Invalid withdrawal amount. Please Enter a valid input.\n");
        }
    }
   String checkBalance(){
        return "The balance of "+this.accountHolder+" is: $" +this.balance+ "\n";
   }
    String getDetails() {
        return "Account Holder: " + this.accountHolder +"\nAccount no: "+  this.accountno +"\nGender: "+this.gender+ "\nCurrent Balance: $" + this.balance +"\nTransaction limit: $" +this.transLimit + "\n";
    }

    void trasnfer (BankAccount a1, double amount){
        if(amount<this.balance && amount<this.transLimit && amount>0) {
            System.out.println("The account "+this.accountHolder+" has successfully transferred $"+amount+" to the account " +a1.accountHolder + "\n");
            this.withdraw(amount);
            a1.deposit(amount);
        }
        else if(amount<this.transLimit){
            System.out.println("The transfer exceeeds the sender: "+this.accountHolder+" transfer limit: $"+this.transLimit+ "\n");
        }
        else if(amount<this.balance){
            System.out.println("The transfer exceeeds the sender: "+this.accountHolder+" Current Balance: $"+this.balance+ "\n");
        }
        else {
            System.out.println("Invalid amount. please transfer a valid amount\n");
        }
    }
}
