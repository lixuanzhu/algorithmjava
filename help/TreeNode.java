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
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            TreeNode cur = q.poll();
            if(cur == null) {
                res = res.append(" n");
                continue;
            }
            res = res.append(" ").append(cur.val);
            q.add(cur.left);
            q.add(cur.right);
        }

        for(int i = res.length() - 1; i >=0; i--){
            char c = res.charAt(i);
            if(c != 'n' && c != ' '){
                break;
            }

            res.deleteCharAt(i);
        }
        return res.toString().trim();
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
            if(i == arr.length - 1){
                break;
            } else {
                i++;
                if(!arr[i].equals("n")){
                    cur.right = new TreeNode(Integer.parseInt(arr[i]));
                    q.add(cur.right);
                }
            }
        }

        return res;
    }

    public static void print(TreeNode root){
        print(root, 0);
    }

    private static void print(TreeNode root, int level){
        if(root == null){
            return;
        }
        print(root.left, level + 1);
        System.out.println("    ".repeat(level) + root.val);
        print(root.right, level +1); 
    }

    public static void main(String[] args){
        String str = "1 2 n n 4 5 6";
        TreeNode node = fromString(str);
        String str2 = toString(node);
        System.out.println(str2);
        print(node);
    }
}