package practicepackage;

import java.util.Scanner;

public class node {
    int roll;
    String name;
    float cg;
    node link;

    node(int roll, String name, float cg) {
        this.roll = roll;
        this.cg = cg;
        this.name = name;
        this.link = null;
    }

    public void createNode(node adam, int roll, String name, float cg) {
        node current = new node(roll, name, cg);
        node looper = adam;
        while (looper.link != null) {
            looper = looper.link;
        }
        looper.link = current;
       // System.out.println(current.roll + current.name + current.cg);
        current.link = null;
    }

    public void inputAnode(node adam){
        Scanner in = new Scanner(System.in);
        int roll = in.nextInt();
        String name = in.next();
        float cg = in.nextFloat();
        createNode(adam,roll,name,cg);
    }


    public void deleteAnode(node adam,int roll){

        adam.printThell(adam);
    }

    public void printThell(node adam) {
        node looper = adam;
        while (looper != null) {
            System.out.println(looper.roll+" " + looper.name+" " + looper.cg);
            looper = looper.link;
        }
    }
}
