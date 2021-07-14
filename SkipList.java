import java.util.Random;

public class SkipList {
    private static final double PROMOTE_RATE = 0.5;
    private Node head;
    private Node tail;
    private int maxLevel;

    public class Node{
        public int data;
        public Node up, down, left, right;

        public Node(int data){
            this.data = data;
        }
    }

    public SkipList(){
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }
    public Node search(int data){
        Node p = findNode(data);
        if(p.data ==data){
            System.out.println("Found: " + data);
            return p;
        }
        System.out.println("Not found: " + data);
        return null;
    }

    private Node findNode(int data){
        Node node = head;
        while(true){
            while (node.right.data != Integer.MAX_VALUE && node.right.data <=data){
                node = node.right;
            }
            if(node.down == null){
                break;
            }
            node = node.down;
        }
        return node;
    }

    public void insert(int data){
        Node preNode = findNode(data);
        if(preNode.data == data){
            return;
        }
        Node node = new Node(data);
        appendNode(preNode, node);
        int currentLevel = 0;
        Random random = new Random();
        while(random.nextDouble() < PROMOTE_RATE){
            if(currentLevel == maxLevel){
                addLevel();
            }
            while(preNode.up == null){
                preNode = preNode.left;
            }
            preNode = preNode.up;
            Node upperNode = new Node(data);
            appendNode(preNode, upperNode);
            upperNode.down = node;
            node.up = upperNode;
            node = upperNode;
            currentLevel++;
        }
    }

    private void appendNode(Node preNode, Node newNode){
        newNode.left = preNode;
        newNode.right = preNode.right;
        preNode.right.left = newNode;
        preNode.right = newNode;
    }

    private void addLevel(){
        maxLevel++;
        Node p1 = new Node(Integer.MIN_VALUE);
        Node p2 = new Node(Integer.MAX_VALUE);
        p1.right = p2;
        p2.left = p1;
        p1.down = head;
        head.up = p1;
        p2.down = tail;
        tail.up = p2;
        head = p1;
        tail = p2;
    }

    public boolean remove(int data){
        Node removedNode = search(data);
        if(removedNode == null){
            return false;
        }
        int currentLevel = 0;
        while(removedNode != null){
            removedNode.right.left = removedNode.left;
            removedNode.left.right = removedNode.right;
            if(currentLevel !=0 && removedNode.left.data == Integer.MIN_VALUE && removedNode.right.data == Integer.MAX_VALUE){
                removeLevel(removedNode.left);
            } else {
                currentLevel++;
            }
            removedNode = removedNode.up;
        }
        return true;
    }

    private void removeLevel(Node leftNode){
        Node rightNode = leftNode.right;
        if(leftNode.up == null){
            leftNode.down.up = null;
            rightNode.down.up =null;
        } else {
            leftNode.up.down = leftNode.down;
            leftNode.down.up = leftNode.up;
            rightNode.up.down = rightNode.down;
            rightNode.down.up = rightNode.up;
        }
        maxLevel--;
    }
}
