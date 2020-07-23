import java.util.*;

public class MaxDistance {
    public int maxDistance(int[][] grid){
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0,1}};
        int n = grid.length;
        Deque<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){ 
                    q.addLast(new int[] {i,j});
                }
            }
        }

        int max = -1;
        while (q.size() != 0){
            int s = q.size();
            for (int k = 0; k < s; k++){
                int[] p = q.removeFirst();
                for (int[] dir : dirs){
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if (x >= 0 && x < n && y >=0 && y < n && grid[x][y] == 0){
                        q.addLast(new int[] {x, y});
                        grid[x][y] = 1;
                    }
                }
            }

            max++;
        }
       
        return max < 1 ? -1 : max;
    }
    
    public static void main(String[] args){
        int arr[][] = { {1,0,0},{0,0,0},{0,0,0} };
        MaxDistance m = new MaxDistance();
        int d = m.maxDistance(arr);
        System.out.println(d);
    }
}