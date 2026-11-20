package practicepackage;

import java.util.Arrays;

public class methods {
    static void main(String[] args) {

        int [] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arr));
        changeArr(arr);
        System.out.println(Arrays.toString(arr));

     }
    public static void changeArr(int[] arr){
            arr[5] = 1234;
        }

    }