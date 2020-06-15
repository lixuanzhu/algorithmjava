import java.util.*;
import help.*;

public class TraverseTree{
    public static void preorderRecursive(TreeNode root, List<Integer> res){
        if(root != null){
            res.add(root.val);
            preorderRecursive(root.left, res);
            preorderRecursive(root.right, res);
        }
    }

    public static void inorderRecursive(TreeNode root, List<Integer> res){
        if(root != null){
            inorderRecursive(root.left, res);
            res.add(root.val);
            inorderRecursive(root.right, res);
        }
    }

    public static void postorderRecursive(TreeNode root, List<Integer> res){
        if(root != null){
            postorderRecursive(root.left, res);
            postorderRecursive(root.right, res);
            res.add(root.val);
        }
    }

    public static void preorderIterative(TreeNode root, List<Integer> res){
        Stack<TreeNode> s = new Stack<>();
        while (s.size() > 0 || root != null){
            while(root != null){
                s.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
    }

    public static void preorderIterative2(TreeNode root, List<Integer> res){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (s.size() > 0){
            TreeNode r = s.pop();
            res.add(r.val);
            if(r.right != null){
                s.push(r.right);
            }
            if(r.left != null){
                s.push(r.left);
            }
        }
    }

    public static void inorderIterative(TreeNode root, List<Integer> res){
        Stack<TreeNode> s = new Stack<>();
        while (s.size() > 0 || root != null){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            res.add(root.val);
            root = root.right;
        }
    }

    public static void inorderIterative2(TreeNode root, List<Integer> res){
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, false));
        while (s.size() > 0){
            Pair r = s.pop();
            if(r.self){
                res.add(r.node.val);
                continue;
            }
            
            if(r.node.right != null){
                s.push(new Pair(r.node.right, false));
            }

            s.push(new Pair(r.node, true));

            if(r.node.left != null){
                s.push(new Pair(r.node.left, false));
            }
        }
    }

    public static void postorderIterative(TreeNode root, List<Integer> res){
        Stack<TreeNode> s = new Stack<>();
        while (s.size() > 0 || root != null){
            while(root != null){
                s.push(root);
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(s.size() == 0) return; 
            if(root == s.peek()) {
                root = root.right;
            } else {
                res.add(root.val);
                root = null;
            }
        }
    }
    // Reverse preorder of right first, root, right, left -> left, right, root
    public static void postorderIterative2(TreeNode root, List<Integer> res){
        Stack<TreeNode> s = new Stack<>();
        while (s.size() > 0 || root != null){
            while(root != null){
                s.push(root);
                res.add(0, root.val);
                root = root.right;
            }
            root = s.pop();
            root = root.left;
        }
    }

    public static void postorderIterative3(TreeNode root, List<Integer> res){
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, false));
        while (s.size() > 0){
            Pair r = s.pop();
            if(r.self){
                res.add(r.node.val);
                continue;
            }
            
            s.push(new Pair(r.node, true));

            if(r.node.right != null){
                s.push(new Pair(r.node.right, false));
            }    

            if(r.node.left != null){
                s.push(new Pair(r.node.left, false));
            }
        }
    }

    public static void main(String[] args){
        List<Integer> res = new LinkedList<>();
        String str = "1 2 3 4 5 6 7";
        TreeNode root = TreeNode.fromString(str);
        postorderIterative3(root, res);
        Util.print(res);
    }
}