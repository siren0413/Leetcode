package question;
import beans.ListNode;

public class ReorderList {
	public static void reorderList(ListNode head){
		if(head == null )
			return;
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		if(mid == null)
			return;
		slow.next = null;
		mid = reverseList(mid,null);
		ListNode temp = head;
		while(temp!=null && mid!=null){
			ListNode nextMid = mid.next;
			mid.next = temp.next;
			temp.next = mid;
			mid = nextMid;
			temp = temp.next.next;
		}
	}
	
	public static ListNode reverseList(ListNode head, ListNode pre){
		if(head == null)
			return pre;
		ListNode temp = head.next;
		head.next = pre;
		return reverseList(temp,head);
	}
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		reorderList(node1);
		while(node1!=null){
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}
}
