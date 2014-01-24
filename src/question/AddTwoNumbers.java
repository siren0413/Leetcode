package question;

import beans.ListNode;

/**
 * Created by admin on 1/23/14.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            val += carry;
            carry = val / 10;
            dummy.next = new ListNode(val % 10);
            dummy = dummy.next;
        }
        if (carry > 0) dummy.next = new ListNode(carry);
        return head.next;
    }


    // test
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode head = addTwoNumbers(n1, m1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
