import java.util.*;
import help.*;

public class TreeBoundary {
    public static List<Integer> getBoundary(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        TreeNode boundary = root.left;
        while ( boundary != null){
            res.add(boundary.val);
            if(boundary.left != null){
                boundary = boundary.left;
            } else if (boundary.right != null){
                boundary = boundary.right;
            } else {
                boundary = null;
            }
        }

        res.remove(res.size() -1);
        addLeaf(root, res);
        res.remove(res.size() -1);

        List<Integer> right = new ArrayList<>();
        boundary = root.right;
        while ( boundary != null){
            right.add(boundary.val);
            if(boundary.right != null){
                boundary = boundary.right;
            } else if (boundary.left != null){
                boundary = boundary.left;
            } else {
                boundary = null;
            }
        }

        for(int i = right.size() -1 ; i >=0; i--){
            res.add(right.get(i));
        }
        return res;
    }

    private static void addLeaf(TreeNode root, List<Integer> res){
        if(root.left == null && root.right == null){
            res.add(root.val);
        }
        if(root.left != null){
            addLeaf(root.left, res);
        }
        if(root.right != null){
            addLeaf(root.right, res);
        }
    }

    public static void main(String[] args){
        String tree = "40 20 60 10 30 50 70 n 5 n n n 55 n n n 45";
        TreeNode root = TreeNode.fromString(tree);
        List<Integer> res = TreeBoundary.getBoundary(root);
        for(int i = 0; i < res.size(); i++){
            System.out.print(res.get(i));
            System.out.print("\t");
        }

        System.out.println();
    }
}