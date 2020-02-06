import java.util.*;

class LongestSubstring{
    public static String getLongestSubstring(String str){
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int maxstart = 0;
        int start = 0;
        for (int i  = 0; i< str.length(); i++) {
            Character c = str.charAt(i);
            if (map.containsKey(c)){
                int index = map.get(c);
                if (index >= start){
                    if (max < i - start){
                        max = i -start;
                        maxstart = start;
                    }
                    start = index + 1;
                }
            }
            map.put(c, i);
        }
        if( max < str.length() -start){
            max = str.length() -start;
            maxstart = start;
        }
        return str.substring(maxstart, maxstart + max);
    }
    public static void main(String[] args){
        String str = "abcbdfdaccadef";
        System.out.println(str);
        System.out.println(getLongestSubstring(str));
    }
}