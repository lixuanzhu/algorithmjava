import java.util.Random;

class QuickSort{
    
    public static int partition(int[] arr, int left, int right){
        Random r = new Random();
        int p = r.nextInt(right - left + 1) + left;
        swap(arr, p, right);
        int larger = left;
        for(int cur = left; cur < right; cur++)
        {
            if(arr[cur] < arr[right]){
                swap(arr, cur, larger);
                larger++;
            }
        }

        swap(arr, larger, right);
        return larger;
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot -1);
        quickSort(arr, pivot + 1, right);
    }
    public static void main(String[] args){
        int[] arr = new int[] {6, 3, 9, 2, 10, 12, 4, 7, 34, 56, 13, 5};
        quickSort(arr, 0, arr.length -1);
        printArray(arr);
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void printArray(int[] arr){
        for (int n : arr) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
}