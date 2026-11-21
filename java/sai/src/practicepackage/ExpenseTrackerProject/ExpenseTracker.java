package practicepackage.ExpenseTrackerProject;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class ExpenseTracker {
    int reserve;
    ExpenseTracker(int reserve){
        this.reserve = reserve;
    }

    public void deposit() {
        Path path = Path.of("takapoysha.txt");
        Scanner sc = new Scanner(System.in);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int reserve = Integer.parseInt(lines.get(0).trim());
        this.reserve = reserve;

        System.out.println("current reserve is: "+this.reserve);
        System.out.println("input the amount to deposit: ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.println("input the source of the money: ");
        String why = sc.nextLine();
        System.out.println("input the date and time: ");
        String date = sc.nextLine();

        if (amount > 0) this.reserve = amount + this.reserve;
        lines.set(0, String.valueOf(this.reserve));
        lines.add("\n(deposit)"+date);
        lines.add("deposit: " + amount);
        lines.add("source: "+why);
        lines.add("current: " + this.reserve);

        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Path rasta = Path.of("poyshapati.csv");
        String row = date + "," +reserve + ",+" + amount +","+why+","+this.reserve ;
        try {
            Files.writeString(rasta,row,StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeOut() {
        Path path = Path.of("takapoysha.txt");
        Scanner sc = new Scanner(System.in);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int reserve = Integer.parseInt(lines.get(0));
        this.reserve = reserve;
        System.out.println("current reserve is: "+this.reserve);
        System.out.println("input the amount to take out: ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.println("input the reason: ");
        String why = sc.nextLine();
        System.out.println("input the date and time: ");
        String date = sc.nextLine();

        if (amount > 0) this.reserve = this.reserve - amount;
        lines.set(0, String.valueOf(this.reserve));
        lines.add("\n(takeout)"+date);
        lines.add("extracted: " + amount);
        lines.add("reason: "+why);
        lines.add("current: " + this.reserve);

        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path rasta = Path.of("poyshapati.csv");
        String row = date + "," +reserve + ",-" + amount +","+why+","+this.reserve ;
        try {
            Files.writeString(rasta,row,StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
