package question;

import beans.ListNode;

/**
 * Created by admin on 1/22/14.
 */
public class SwapNodesInPairs {

    // recursive
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        return swapPairsHelper(head);
    }

    private static ListNode swapPairsHelper(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;
        head.next.next = swapPairsHelper(head.next.next);
        return head;
    }


    // iteration
    public static ListNode swapPairs2(ListNode head){
        if(head == null) return null;
        ListNode start = head, last = null;
        while(start!=null && start.next!=null){
            ListNode temp = start;
            start = start.next;
            temp.next = start.next;
            start.next = temp;
            if(last == null)
                head = start;
            else last.next = start;
            last = start.next;
            start = start.next.next;
        }
        return head;
    }



    // test
    public static void main(String[] args) {
        beans.ListNode n1 = new beans.ListNode(1);
        beans.ListNode n2 = new beans.ListNode(2);
        beans.ListNode n3 = new beans.ListNode(3);
        beans.ListNode n4 = new beans.ListNode(4);
        beans.ListNode n5 = new beans.ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        beans.ListNode head = swapPairs2(n1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
