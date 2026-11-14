package practicepackage;
import java.util.Scanner;
public class Sum {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a1 = input.nextInt();
        int a2 = input.nextInt();
        int sum = a1 + a2;
        System.out.println( a1 + "+" + a2 + "=" + sum);
    }
}
