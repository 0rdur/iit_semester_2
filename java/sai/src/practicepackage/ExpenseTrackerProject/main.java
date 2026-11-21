package practicepackage.ExpenseTrackerProject;

import java.util.Scanner;

public class main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseTracker rudro = new ExpenseTracker(0);
        while(true) {
            System.out.println("1 for deposit, 2 for takeout, 3 to quit");
            int s = sc.nextInt();
            if (s == 1) rudro.deposit();
            if (s == 2) rudro.takeOut();
            if (s == 3) break;
        }
    }
}
