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
        ListNode cur = dummy;
        int carry  = 0;
        while (l1!= null || l2 != null || carry !=0){
            int sum = carry;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        return dummy.next;
    }
}