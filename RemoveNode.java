import java.util.*;
import help.*;

public class RemoveNode{
    public static List<TreeNode> removeNode(TreeNode root){
        List<TreeNode> res = new ArrayList<>();
        if(!shouldRemove(root)){
            res.add(root);
        }
        dfs(root, res);
        return res;
    }

    public static void dfs(TreeNode root, List<TreeNode> res){
        if( root == null){
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        if(!shouldRemove(root)){
            if (root.left != null && shouldRemove(root.left)){
                root.left = null;
            }
            if (root.right != null && shouldRemove(root.right)){
                root.right = null;
            }
        } else {
            if (root.left != null && !shouldRemove(root.left)){
                res.add(root.left);
            }
            if (root.right != null && !shouldRemove(root.right)){
                res.add(root.right);
            }
        }
    }

    public static boolean shouldRemove(TreeNode root){
        Set<Integer> del  = Set.of(2);
        return  del.contains(root.val);
    }

    public static void main(String[] args){
        String str = "1 2 3 4 5 6 7";
        TreeNode root = TreeNode.fromString(str);
        List<TreeNode> res = removeNode(root);
        for(TreeNode node : res){
            System.out.println(TreeNode.toString(node));
            TreeNode.print(node);
            System.out.println();
        }
    }
}