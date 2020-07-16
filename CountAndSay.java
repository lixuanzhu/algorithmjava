class CountAndSay {
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        
        String p = countAndSay(n-1);
        StringBuilder res = new StringBuilder();
        int count = 0;
        Character c = p.charAt(0);
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == c){
                count++;
            } else {
                res.append(count).append(c);
                c = p.charAt(i);
                count = 1;
            }
        }
        
        res.append(count).append(c);
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(countAndSay(9));
    }
}