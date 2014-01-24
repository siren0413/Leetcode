package question;

import beans.ListNode;

/**
 * Created by admin on 1/22/14.
 */
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode groupStart = head, lastTail = null;
        while (groupStart != null) {
            int n = k;
            ListNode temp = groupStart;
            while(temp!=null && n>0){
                temp = temp.next;
                n--;
            }
            if(n!=0) return head;

            ListNode start = reverse(groupStart, null, groupStart, k);
            if (lastTail == null) head = start;
            else lastTail.next = start;

            lastTail = groupStart;
            groupStart = groupStart.next;
        }
        return head;
    }

    private static ListNode reverse(ListNode head, ListNode pre, ListNode start, int n) {
        if (n == 0) {
            start.next = head;
            return pre;
        }
        ListNode temp = head.next;
        head.next = pre;
        pre = head;
        return reverse(temp, pre, start, n - 1);
    }



    // test
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
       // n2.next = n3;
        //n3.next = n4;
        //n4.next = n5;
        ListNode head = reverseKGroup(n1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
