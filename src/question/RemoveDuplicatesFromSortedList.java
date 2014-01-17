package question;

import beans.ListNode;

/**
 * Created by admin on 1/16/14.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode scout = head;
        ListNode pre = null;
        while (scout != null) {
            if (pre != null && pre.val == scout.val) {
                pre.next = scout.next;
                scout = pre.next;
                continue;
            }
            pre = scout;
            scout = scout.next;
        }
        return head;
    }



    //test
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = deleteDuplicates(n1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
