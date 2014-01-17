package question;

import beans.ListNode;

/**
 * Created by admin on 1/16/14.
 */
public class RemoveDuplicatesFromSortedList2 {

    // better method
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        ListNode scout = head;
        while(scout.next!=null){
            ListNode node = scout.next;
            while(node.next!=null && node.next.val == node.val) node = node.next;
            if(scout.next == node) scout = scout.next;
            else scout.next = node.next;
        }
        return head.next;
    }


    public static ListNode deleteDuplicates2(ListNode head){
        if (head == null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode scout = head;
        while (scout != null) {
            int val = scout.val;
            if(scout.next!=null && (int)scout.next.val == val){
                while(scout!=null && (int)scout.val == val){
                    if(scout.next!=null){
                        scout.val = scout.next.val;
                        scout.next = scout.next.next;
                    }else{
                        scout = null;
                        if(pre.next == head){
                            head = null;
                        }else{
                            pre.next = null;
                        }
                    }
                }
                continue;
            }
            pre = scout;
            scout= scout.next;
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
        ListNode head = deleteDuplicates2(n1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
