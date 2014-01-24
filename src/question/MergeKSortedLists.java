package question;

import java.util.*;

import beans.ListNode;

/**
 * Created by admin on 1/22/14.
 */
public class MergeKSortedLists {
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!lists.isEmpty()) {
            ListNode min = null;
            int index = -1;
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) == null) continue;
                if (min == null) {
                    min = lists.get(i);
                    index = i;
                } else if (lists.get(i).val < min.val) {
                    min = lists.get(i);
                    index = i;
                }
            }
            if (index == -1) break;
            dummy.next = min;
            dummy = dummy.next;
            lists.set(index, lists.get(index).next);
        }
        return head.next;
    }


    // test
    public static void main(String[] args) {
        beans.ListNode n1 = new beans.ListNode(1);
        beans.ListNode n2 = new beans.ListNode(4);
        beans.ListNode n3 = new beans.ListNode(7);
        beans.ListNode n4 = new beans.ListNode(11);
        beans.ListNode n5 = new beans.ListNode(20);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode m1 = new ListNode(3);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(8);
        ListNode m4 = new ListNode(15);
        ListNode m5 = new ListNode(16);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(n1);
        list.add(m1);
        list.add(null);
        beans.ListNode head = mergeKLists(list);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
