import help.*;

public class CreateTree {
    static TreeNode buildPreIn(int[] pre, int[] in){
        return buildPreIn(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    
    static TreeNode buildPreIn(int[] pre, int pres, int pref, int[] in, int ins, int inf){
        if(pres > pref || ins > inf){
            return null;
        }
        int rootIndex = ins;
        for(int i = ins; i <= inf; i++){
            if (pre[pres] == in[i]){
                rootIndex = i;
                break;
            }
        }
        int left = rootIndex - ins;
        TreeNode root = new TreeNode(pre[pres]);
        root.left = buildPreIn(pre, pres + 1, pres + left, in, ins, rootIndex - 1);
        root.right = buildPreIn(pre, pres + left + 1, pref, in, rootIndex + 1, inf);
        return root;
    }

    public static void main(String[] args){
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode root = buildPreIn(pre, in);
        TreeNode.print(root);
    }
}
