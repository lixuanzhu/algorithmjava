import java.util.*;

class KthSmallest{
    public static int sort(int[] arr, int k){
        Arrays.sort(arr);
        return arr[k-1];
    }

    public static int maxHeap(int[] arr, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++){
            if(queue.size() < k){
                queue.add(arr[i]);
            } else {
                if(arr[i] < queue.peek()){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        return queue.peek();
    }

    public static int quickSelect(int[] arr, int left, int right, int k){
        int pivot = QuickSort.partition(arr, left, right);
        if(pivot == left + k - 1){
            return arr[pivot];
        } else if (pivot > left + k - 1){
            return quickSelect(arr, left, pivot - 1, k);
        } else {
            return quickSelect(arr, pivot + 1, right, left + k - 1 - pivot );
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{4, 34, 45, 7, 2, 54, 23, 13, 8, 10, 23, 3, 24, 67, 345, 86, 5, 11, 44, 55};
        int k = 14;
        System.out.println(sort(arr.clone(), k));
        System.out.println(maxHeap(arr.clone(), k));
        System.out.println(quickSelect(arr.clone(), 0, arr.length -1, k));
    } 
}
