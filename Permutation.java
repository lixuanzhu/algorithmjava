import java.util.*;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permute(res, nums, 0);
        return res;
    }

    public static void permute(List<List<Integer>> res, int[] nums, int pos){
        if( nums.length == pos){
            List<Integer> l = new ArrayList<>();
            for(int a : nums){
                l.add(a);
            }
            res.add(l);
            return;
        }

        for(int i = pos; i < nums.length; i++){
            if( i > pos && nums[i] == nums[i - 1]){
                continue;
            }
            swap(nums, i, pos);
            permute(res, nums, pos + 1);
            swap(nums, i, pos);
        }
    }

    public static void swap(int[] nums, int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args){
        int[] nums = {3, 1, 3, 1};
        List<List<Integer>> res = permute(nums);
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < res.get(i).size(); j++){
                System.out.print(res.get(i).get(j) + "  ");
            }
            System.out.println();
        }

    }
}