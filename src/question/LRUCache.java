package question;

import java.util.HashMap;

public class LRUCache {
	private ListNode head;
	private ListNode tail;
	private HashMap map = new HashMap();
	private int capacity = 0;
	private int size = 0;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		ListNode node = (ListNode) map.get(key);
		if (node == null)
			return -1;
		moveToFirst(node);
		return node.val;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			ListNode node = (ListNode) map.get(key);
			node.val = value;
			moveToFirst(node);
			return;
		}
		size++;
		if (size > capacity) {
			size--;
			removeLast();
		}
		ListNode newNode = new ListNode(key, value);
		addFirst(newNode);

	}

	public void addLast(ListNode node) {
		if (node == null)
			return;
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.pre = tail;
			tail = node;
		}
		map.put(node.key, node);
		size++;
	}

	public void addFirst(ListNode node) {
		if (node == null)
			return;
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.pre = node;
			head = node;
		}
		map.put(node.key, node);
	}

	public ListNode removeLast() {
		if (head == null || tail == null)
			return null;
		ListNode removedNode = tail;
		if (size == 1) {
			tail = head;
		} else {
			tail = tail.pre;
			tail.next = null;
		}
		map.remove(removedNode.key);
		return removedNode;
	}

	public void moveToFirst(ListNode node) {
		if (node == null || node == head) {
			return;
		}
		if (node != head && node == tail) {
			tail = node.pre;
		}
		ListNode temp = node;
		node.pre.next = node.next;
		node.next = head;
		head.pre = node;
		head = node;
	}
}

class ListNode {
	int val;
	int key;
	ListNode next;
	ListNode pre;
	ListNode(int key, int x) {
		this.key = key;
		val = x;
		next = null;
		pre = null;
	}
	
	@Override
	public int hashCode(){
		return key;	
	}
	
	@Override
	public boolean equals(Object obj){
		ListNode node = (ListNode)obj;
		return 	this.key == node.key;
	}
}

