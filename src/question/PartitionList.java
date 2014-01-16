package question;

import beans.ListNode;

/**
 * Created by admin on 1/15/14.
 */
public class PartitionList {

    // insertion method
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummy = new ListNode(x-1);
        dummy.next = head;
        ListNode less = dummy;
        ListNode scout = head;
        ListNode pre = dummy;
        while (scout != null) {
            if (scout.val < x) {
                if(pre.val >= x){
                    ListNode temp = scout.next;
                    scout.next = less.next;
                    less.next = scout;
                    scout = temp;
                    pre.next = scout;
                    less = less.next;
                    continue;
                }
                less = less.next;
            }
            pre = scout;
            scout = scout.next;
        }
        return dummy.next;
    }


    // create two list (small, big) and link them together at end;
    public static ListNode partition2(ListNode head, int x){
        if(head == null) return null;
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode small = head1;
        ListNode big = head2;
        while(head!=null){
            ListNode temp = head.next;
            head.next = null;
            if(head.val < x ){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = temp;
        }
        small.next = head2.next;
        return head1.next;
    }




    // test
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode head = partition2(n1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
