import help.*;

class AddTwoNumbers
{
    public static void main(String[] args){
        ListNode l1 = ListNode.create(new int[] {2, 4,6});
        ListNode l2 = ListNode.create(new int[] {9, 3,6});
        ListNode s = addTwoNumbers(l1, l2);
        ListNode.print(l1);
        ListNode.print(l2);
        ListNode.print(s);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = dummy;
        int carry  = 0;
        while( p!= null || q != null){
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x+ y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if(p != null){
                p = p.next;
            }

            if(q != null){
                q = q.next;
            }
        }

        if(carry > 0){
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}