import java.util.Scanner;

public class KhaledSirIssues {
    static void main(String[] args) {
        //*******************************     == and .equal
        String name1 = new String();
//        String name2 = new String();
        Scanner in = new Scanner(System.in);

        name1 = in.nextLine();
//        name2 = in.nextLine();
//        if(name1 == name2) System.out.println("they are the same name(==)");
//        else if(name1.equals(name2)) System.out.println("they are the same name (.ewuals)");
//        else System.out.println("kichui kaj korena");

        //********************************** switch
        switch(name1) {
            case  "rudro" -> System.out.println("the name is rudro");
            case  "shafin" -> System.out.println("the name is shafin");
            case  "tahsin" -> System.out.println("the name is tahsin");
            case "snaho" -> System.out.println("the name is snaho");
            default-> System.out.println("the name is : "+ name1);
        }
    }
}
