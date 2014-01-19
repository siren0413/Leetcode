package question;

import beans.ListNode;

/**
 * Created by admin on 1/18/14.
 */

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode left = l1;
        ListNode right = l2;
        ListNode temp = head;
        while(left!=null & right!=null){
            if(left.val <= right.val){
                temp.next = left;
                left = left.next;
            }else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left == null? right:left;
        return head.next;
    }



    //test
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(5);
        ListNode m4 = new ListNode(10);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        ListNode head = mergeTwoLists(n1,m1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
