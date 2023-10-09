package structrue_ch3;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> map;
    DList cache;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        this.cache.removeNode(node);
        this.cache.addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(key);
            this.cache.removeNode(node);
            Node newNode = new Node(key, value);
            this.map.put(key, newNode);
            this.cache.addToHead(newNode);
            return;
        }
        if (cache.size == capacity) {
            Node delNode = this.cache.removeLastNode();
            map.remove(delNode.key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        this.cache.addToHead(newNode);
    }

    class DList {
        int size;
        Node head, tail;

        DList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.size = 0;
            head.next = tail;
            tail.next = head;
        }

        void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            this.size++;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            this.size--;
        }

        private Node removeLastNode() {
            if (head == tail.prev) {
                return null;
            }
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
    }

    class Node {
        int key;
        int value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        System.out.println(cache.get(2));
    }
}
