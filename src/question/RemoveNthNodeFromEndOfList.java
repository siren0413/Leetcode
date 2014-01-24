package question;

import beans.ListNode;

/**
 * Created by admin on 1/22/14.
 */
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null) return null;
        ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
        dummy.next = head;
        head = dummy;
        while(n>=0){
            fast = fast.next;
            n--;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head.next;
    }


    //test
    public static void main(String[] args){
        ListNode m1 = new ListNode(3);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(8);
        ListNode m4 = new ListNode(15);
        ListNode m5 = new ListNode(16);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        ListNode head = removeNthFromEnd(m1,2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
