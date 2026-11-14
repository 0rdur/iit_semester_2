package practicepackage;

import java.util.Scanner;

public class Tasks {
    boolean done;
    String taskName;
    float time;

    Tasks(String taskName, float time, boolean done){
      this.taskName = taskName;
      this.time = time;
      this.done = done;
    }
     public static void display(Tasks[] arr){
        for(Tasks s : arr){
        System.out.println(s.taskName +"--"+ s.time+ "--"+" is this task done: " + s.done);
    }
}
  static Tasks takeTheinput(Scanner input) {
      String nm = input.nextLine();
      float tm = input.nextFloat();
      input.nextLine();
      boolean dn = false;

      return new Tasks(nm, tm, dn);
  }

  static Tasks [] takeTheinputTotal(Scanner input){
        Tasks[] arr = new Tasks[20];
     for(int i = 0; i<20 ; i++){
         arr[i] = takeTheinput(input);
         if(arr[i].time > 24.00f) {
             break;
         }
         }
     return arr;
     }

}

