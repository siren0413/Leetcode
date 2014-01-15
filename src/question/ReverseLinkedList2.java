package question;

/**
 * Created by admin on 1/15/14.
 */

import beans.ListNode;

public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode temp = head;
        ListNode pre = null;
        int cnt = 1;
        while (temp != null) {
            if (cnt == m) {
                ListNode start = reverse(temp, null, temp, n - m + 1);
                if (pre == null) return start;        // if reverse from the start of the list, then just return the reversed start
                else pre.next = start;              // if not, then concatenate with pre.
                break;
            }
            pre = temp;
            temp = temp.next;
            cnt++;
        }
        return head;
    }

    private static ListNode reverse(ListNode head, ListNode pre, ListNode end, int count) {
        if (count == 0) {
            end.next = head;
            return pre;
        }
        ListNode temp = head.next;
        head.next = pre;
        return reverse(temp, head, end, count - 1);
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
         n2.next = n3;
       // n3.next = n4;
        n4.next = n5;
        ListNode head = reverseBetween(n1, 2, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
