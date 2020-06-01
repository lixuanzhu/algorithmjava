package help; 

import java.util.*;

public class Util{
    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void print(List<Integer> list){
        for (int n : list) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }

    public static void print(int[] list){
        for (int n : list) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
} 