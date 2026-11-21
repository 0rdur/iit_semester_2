package practicepackage;

import java.util.Arrays;

public class methods {
    static void main(String[] args) {

        int [] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arr));
        changeArr(arr);
        System.out.println(Arrays.toString(arr));

        //overloading
        add(1,2,3);
        add(1,2);

        //var arguments
        add(1,2,3,4,5,6,7,8);

     }
    public static void changeArr(int[] arr){
            arr[5] = 1234;
        }

    public static void add(int a,int b,int c){
        System.out.println(a+"+"+b+"+"+c+"="+(a+b+c));
    }
    public static void add(int a,int b){
        System.out.println(a+"+"+b+"="+(a+b));
    }
    //var size arg
    public static void add(int ...a){
        int sum = 0;
        System.out.println(Arrays.toString(a));
        for(int i = 0; i< a.length ; i++) sum += a[i];
        System.out.println("the sum is "+sum);
    }
    }
