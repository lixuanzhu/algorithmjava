package help; 

public class ListNode{
    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode create(int[] vals){
        ListNode d = new ListNode(0);
        ListNode cur = d;
        for(int i  = 0; i < vals.length; i++){
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }

        return d.next;
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val);
            if(head.next != null){
                System.out.print(" => ");
            }

            head = head.next;
        }

        System.out.println();
    }
}