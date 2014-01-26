package question;

import java.util.*;


public class LRUCache {
    Map<Integer, ListNode> map;
    ListNode head, tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.pre = head;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            moveToFirst(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            moveToFirst(map.get(key));
        }else{
            ListNode node = new ListNode(key,value);
            map.put(key,node);
            insert(node);
        }
    }

    private void moveToFirst(ListNode node){
        if(head.next == node) return;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void insert(ListNode node) {
        if (size >= capacity) {
            remove(tail.pre);
        }
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
        size++;
    }

    private ListNode remove(ListNode node) {
        if(size == 0) return null;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        map.remove(node.key);
        size --;
        return node;
    }


    class ListNode {
        int key, val;
        ListNode next;
        ListNode pre;

        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
            next = null;
            pre = null;
        }
    }




    // test
    public static void main(String[] args){
        LRUCache cache = new LRUCache(5);
        cache.set(10,13);
        cache.set(3,17);
        cache.set(6,11);
        cache.set(10,5);
        cache.set(9,10);
        cache.get(13);
        cache.set(2, 19);
        cache.get(2);
        cache.get(3);
        cache.set(5, 25);
        cache.set(9, 22);
        cache.set(5, 5);
        cache.set(1, 30);
        cache.get(11);
        cache.set(9, 12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.set(4, 30);
        cache.set(9, 3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.set(6, 14);
        cache.set(3, 1);
        cache.get(3);
        cache.set(10, 11);
        cache.get(8);
        cache.set(2, 14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.set(11, 4);
        cache.set(12, 24);
        cache.set(5,18);
    }
}
