import help.*;
class PartitionList{
    public static void main (String[] args){
        int[] arr = new int[] {34, 2, 24, 56, 24, 6, 8, 17, 23, 24, 34, 67, 4, 24};
        Util.print(arr);
        partitionList(arr, 24);
        Util.print(arr);
    }

    public static void partitionList(int[] arr, int k){
        int s = 0;
        for(int f = 0; f < arr.length; f++){
            if(arr[f] <= k){
                Util.swap(arr, s, f);
                s++;
            }
        }
        s = 0;
        for(int f = 0; f < arr.length; f++){
            if(arr[f] < k){
                Util.swap(arr, s, f);
                s++;
            }
        }
    }
}