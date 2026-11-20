package practicepackage;

public class linkedlist {
    static void main(String[] args) {

        node adam = new node(1, "shafin", 4);
        adam.createNode(adam, 2, "fatin", 3);
        adam.createNode(adam, 4, "yusha", 4);
        adam.printThell(adam);
        adam.inputAnode(adam);
        adam.printThell(adam);
        adam.deleteAnode(adam,2);
        adam.printThell(adam);
    }
}