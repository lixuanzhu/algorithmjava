

public class BinarySearch {
    public static void main(String[] args){
        int[] nums = {1, 1, 1, 4, 4, 6, 6};
        System.out.println(search(nums, 3));
        System.out.println(searchLeft(nums, 5));
        System.out.println(searchRight(nums, 4));
        System.out.println(searchLeft2(nums, 7));
        System.out.println(searchRight2(nums, 4));
    }

    static int search(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;            // [] both sides are closed
        while (l <= r){                     // because [] must test l == r
            int m = l + (r - l) / 2;          // avoid overflow
            if (nums[m] == target){
                return m;
            } else if (nums[m] > target){   // clear condition
                r = m - 1;                  // m tested
            } else if (nums[m] < target){   // clear condition
                l = m + 1;                  // m tested
            }
        }

        return  -1; 
    }

    static int searchLeft(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){ 
            int m = l + (r - l) / 2;
            if (nums[m] == target){
                r = m - 1; 
            } else if (nums[m] > target){
                r = m - 1;
            } else if (nums[m] < target){
                l = m + 1;
            }
        }
        
        if ( nums.length == 0 ||    // must check length == 0 
            l >= nums.length ||     // must check boundary
            nums[l] != target)      // Check left value 
            return -1;

        return  l; 
    }

    static int searchRight(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){ 
            int m = l + (r - l) / 2;
            if (nums[m] == target){
                l = m + 1;
            } else if (nums[m] > target){
                r = m - 1;
            } else if (nums[m] < target){
                l = m + 1;
            }
        }

        if (r < 0 || nums[r] != target) // Check right value and must check boundary
            return -1;

        return  r; 
    }

    static int searchLeft2(int[] nums, int target){
        int l = 0;
        int r = nums.length;    // [) Right side open
        while (l < r){ 
            int m = l + (r - l) / 2;
            if (nums[m] == target){
                r = m;          // right open, push to left
            } else if (nums[m] > target){
                r = m ;         // right side open
            } else if (nums[m] < target){
                l = m + 1;
            }
        }

        if (l == nums.length || nums[l] != target)
            return -1;

        return  l; 
    }


    static int searchRight2(int[] nums, int target){
        int l = 0;
        int r = nums.length;    // [) Right side open
        while (l < r){ 
            int m = l + (r - l) / 2;
            if (nums[m] == target){
                l = m + 1;      // left close, push to right
            } else if (nums[m] > target){
                r = m ;         // right side open
            } else if (nums[m] < target){
                l = m + 1;
            }
        }

        if (r == 0 || nums[r-1] != target) // Check right value and must check boundary
            return -1;

        return  l - 1; 
    }
}
