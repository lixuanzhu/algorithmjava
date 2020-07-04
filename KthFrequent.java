import java.util.*;

public class KthFrequent {
    public static List<String> getKthFrequent(String[] words, int k){
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            Integer count = map.getOrDefault(word, 0);
            count++;
            map.put(word, count);
        }

        PriorityQueue<Map.Entry<String, Integer>> min = new PriorityQueue<>(k + 1, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                if(e1.getValue() == e2.getValue()){
                    return e2.getKey().compareTo(e1.getKey());
                }

                return e1.getValue().compareTo(e2.getValue());
            }
        });

        for(Map.Entry<String, Integer> e : map.entrySet()){
            min.offer(e);
            if(min.size() > k){
                min.poll();
            }
        }
        
        List<String> res = new ArrayList<>();
        while (min.size() > 0){
            res.add(min.poll().getKey()); 
        }
        
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){
        String[] words = {"a", "b", "c", "b", "c"};
        List<String> res = getKthFrequent(words, 2);
        for(String r : res){
            System.out.println(r);
        }
    }
}