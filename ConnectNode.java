import java.util.*;
import help.*;

public class ConnectNode {
    public static void main(String[] args){
        String str = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15";
        TreeNode root = TreeNode.fromString(str);
        // connectNode(root);
        connectRow(root);
        TreeNode.print(root);
    }
    
    static void connectNode(TreeNode root){
        if(root != null) {
            connectNode(root.left, root.right);
        }
    }

    static void connectNode(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return;
        }
        connectNode(left.left, left.right);
        connectTree(left.right, right.left);
        connectNode(right.left, right.right);
        left.next = right;
        System.out.println(left.val + " => " + right.val);
    }

    static void connectTree(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return;
        }
        connectTree(left.right, right.left);
        left.next = right;
        System.out.println(left.val + " => " + right.val);
    }

    static void connectRow(TreeNode root){
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(root);
        while (!q.isEmpty()){
            int n = q.size();
            TreeNode pre = null;
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.removeFirst();
                if(pre != null){
                    pre.next = cur;
                    System.out.println(pre.val + " => " + cur.val);
                }
                pre = cur;
                if (cur.left != null){
                    q.addLast(cur.left);
                }
                if (cur.right != null){
                    q.addLast(cur.right);
                }
            }
        }
    }
}
