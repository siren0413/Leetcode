package question;

import beans.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode scout = head;
		while (scout != null) {
			if (scout.val < head.val) {
				int temp = scout.val;
				scout.val = head.val;
				head.val = temp;
			}
			scout = scout.next;
		}
		insertionSortList(head.next);
		return head;
	}

}
