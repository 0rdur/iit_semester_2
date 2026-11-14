package practicepackage;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tasks[] listOftasks = Tasks.takeTheinputTotal(input);
        Tasks.display(listOftasks);
    }
}
