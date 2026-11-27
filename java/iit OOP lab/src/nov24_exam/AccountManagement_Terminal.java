package nov24_exam;

public class AccountManagement_Terminal {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);

        // 1. Terminal Input for Object Creation
//        System.out.print("Enter Account Holder Name: ");
//        String name = scanner.nextLine();

//        System.out.print("Enter Initial Balance: $");
//        double initialBalance = scanner.nextDouble();

        BankAccount account1 = new BankAccount("Maryam Saeed","1001", "Female",10000);
        account1.deposit(3500);
        System.out.println(account1.checkBalance());
        account1.withdraw(1500);
        System.out.println(account1.getDetails());

        BankAccount account2 = new BankAccount("Arshadul Bari","1002","Male",50000);
        System.out.println(account2.getDetails());
        account1.trasnfer(account2,2000);


        System.out.println(account1.checkBalance());
        System.out.println(account2.checkBalance());
//test


    }
}