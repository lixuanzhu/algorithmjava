import help.*;
public class ReverseList {
    static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    static ListNode reverse(ListNode head, int m){
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    public static void main(String[] args){
        int[] vals = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNode.create(vals);
        ListNode.print(head);
        ListNode.print(reverse(head));
    }
}
