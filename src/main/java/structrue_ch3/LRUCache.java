package structrue_ch3;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> map;
    private DList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node findNode = map.get(key);
        cache.delete(findNode);
        cache.addToHead(findNode);
        return findNode.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node findNode = map.get(key);
            findNode.value = value;
            cache.delete(findNode);
            cache.addToHead(findNode);
            return;
        }
        if (cache.size >= capacity) {
            Node delNode = cache.deleteTail();
            map.remove(delNode.key);
        }
        Node addNode = new Node(key, value);
        map.put(key, addNode);
        cache.addToHead(addNode);
    }

    class DList {
        private int size;
        private Node head, tail;

        DList() {
            this.size = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
        }

        public void addToHead(Node node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            size++;
        }

        public void delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node deleteTail() {
            if (tail.prev == head) {
                return null;
            }
            Node delNode = tail.prev;
            delete(delNode);
            return delNode;
        }
    }

    class Node {
        private int key, value;
        private Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
