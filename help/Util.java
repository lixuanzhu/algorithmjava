package help; 

public class Util{
    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void print(int[] arr){
        for (int n : arr) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
} 