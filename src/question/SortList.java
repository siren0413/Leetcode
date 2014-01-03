package question;

import beans.ListNode;

public class SortList {
	public static ListNode sortList(ListNode head){
		if(head == null)
			return null;
		ListNode tail = head;
		while(tail!=null && tail.next!=null){
			tail = tail.next;
		}
		return mergeSort(head,tail);
	}
	
	public static ListNode mergeSort(ListNode start, ListNode end){
		if(start == end)
			return start;
		ListNode fast = start;
		ListNode slow = start;
		while(fast!=null && fast.next!=null && fast!=end && fast.next!=end){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		ListNode left = mergeSort(start,slow);
		ListNode right = mergeSort(mid,end);
		return merge(left,right);
	}
	
	public static ListNode merge(ListNode left, ListNode right){
		ListNode small = left.val < right.val? left: right;
		ListNode big = left.val < right.val? right: left;
		ListNode head = small;
		while(small.next!=null && big!=null){
			if(small.next.val < big.val){
				small = small.next;
			}else{
				ListNode tempBig = big;
				big = big.next;
				tempBig.next = small.next;
				small.next = tempBig;
				small = small.next;
			}
		}
		if(big!=null)
			small.next = big;
		return head;
	}
	
	//test
	public static void main(String[] args) {
		ListNode node4 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node1 = new ListNode(1);
		node4.next = node3;
		node3.next = node2;
		node2.next = node1;
		ListNode node = sortList(node4);
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}
