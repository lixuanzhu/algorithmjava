import java.util.*;

class RainTrap {
    public static int trap(int[] blocks){
        Deque<Integer> s = new ArrayDeque<Integer>();
        int r = 0;
        for(int i = 0; i < blocks.length; i++){
            while (!s.isEmpty() && blocks[i] > blocks[s.peek()]){
                Integer t = s.pop();
                if (s.isEmpty()){
                    break;
                }

                r += (Math.min(blocks[i], blocks[s.peek()]) - blocks[t]) * (i - s.peek() - 1);
            }

            s.push(i);
        }

        return r;
    }

    public static void main(String[] args) {
        int[] b = new int[]{1,2,0,0,4,2,1,0,2,6,6, 0, 2};
        System.out.println(trap(b));
    }
}
