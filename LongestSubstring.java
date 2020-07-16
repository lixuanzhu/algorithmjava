import java.util.*;

class LongestSubstring{
    public static String getLongestSubstring(String str){
        int[] map = new int[128];
        Arrays.fill(map, -1);
        String maxString = "";
        int start = 0;
        for (int i  = 0; i< str.length(); i++) {
            int c = str.charAt(i);
            if (map[c] >= start){
                start = map[c] + 1;
            }
            
            map[c] = i;
            if (i + 1 - start > maxString.length()){
                maxString = str.substring(start, i + 1);
            }
        }

        return maxString;
    }
    
    public static void main(String[] args){
        String str = "abcbadfdaccadef";
        System.out.println(str);
        System.out.println(getLongestSubstring(str));
    }
}