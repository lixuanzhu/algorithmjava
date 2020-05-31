package help; 
import java.util.*;

public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x){
        val = x;
    }

    public static String toString(TreeNode root){
        String res = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() != 0){
            TreeNode cur = q.poll();
            if(cur == null) {
                res = res + " n";
                continue;
            }
            res = res + " " + cur.val;
            q.add(cur.left);
            q.add(cur.right);
        }
        return res;
    }

    public static TreeNode fromString(String str){
        String[] arr = str.split(" ");
        TreeNode res = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(res);

        for(int i = 1; i < arr.length; i++){
            TreeNode cur = q.poll();
            if(!arr[i].equals("n")){
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(cur.left);
            }
            if(i < arr.length - 1) i++;
            if(!arr[i].equals("n")){
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(cur.right);
            }
        }

        return res;
    }

    public static void main(String[] args){
        String str = "1 2 3 n 5 6";
        TreeNode node = fromString(str);
        String str2 = toString(node);
        System.out.println(str2);
    }
}