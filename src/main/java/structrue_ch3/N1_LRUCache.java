package structrue_ch3;

import java.util.HashMap;

//https://leetcode.cn/problems/lru-cache/
public class N1_LRUCache {
    private HashMap<Integer, Node> map;
    private DList cache;
    private int cap;

    public N1_LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.cache = new DList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //从链表删除，并添加到头部
        Node node = map.get(key);
        cache.remove(node);
        cache.addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            cache.remove(node);
            map.remove(key);
            Node newNode = new Node(key, value);
            cache.addToHead(newNode);
            map.put(key, newNode);
            return;
        }
        if (cap == cache.size()) {
            Node node = cache.removeLast();
            map.remove(node.key);
        }
        Node node = new Node(key, value);
        cache.addToHead(node);
        map.put(key, node);
    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DList {
        private Node head, tail;
        private int size;

        public DList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        //链表头部添加节点
        public void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        //remove
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        //remove last
        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node node = tail.prev;
            remove(node);
            return node;
        }

        public int size() {
            return size;
        }
    }
}
