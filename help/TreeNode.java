package help; 
import java.util.*;

public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

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

    public static String toPreString(TreeNode root){
        StringBuilder sb = new StringBuilder();
        toPreString(root, sb);       
        return sb.toString();
    }

    private static void toPreString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("n").append(" ");
            return;
        }
        sb.append(root.val).append(" ");
        toPreString(root.left, sb);
        toPreString(root.right, sb);
    }

    public static TreeNode fromPreString(String pre){
        String[] arr = pre.split(" ");
        List<String> list = new ArrayList<>();
        for(int i = arr.length -1; i >=0; i--){
            list.add(arr[i]);
        }

        return fromPreString(list);
    }

    private static TreeNode fromPreString(List<String> list){
        if(list.size() == 0){
            return null;
        }
        
        String s = list.remove(list.size() - 1);

        if (s.equals("n")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = fromPreString(list);
        root.right = fromPreString(list);
        return root;
    }

    public static void main(String[] args){
        String str = "1 2 3 4 5 n 7";
        TreeNode root = fromString(str);
        print(root);
        String str2 = toString(root);
        System.out.println(str2);
        
        String str3 = toPreString(root);
        System.out.println(str3);
        TreeNode root2 = fromPreString(str3);
        print(root2);
    }
}