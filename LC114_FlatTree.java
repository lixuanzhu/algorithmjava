import help.*;

public class LC114_FlatTree {
    static void flattern(TreeNode root){
        if(root == null){
            return;
        }

        flattern(root.left);
        flattern(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        TreeNode r = root;
        while (r.right != null){
            r = r.right;
        }

        r.right = right;
    }
}
