package structrue_ch3;

import java.util.LinkedList;

public class LRUCacheLinkedList<E> {
    private int cap;
    private LinkedList<E> cache;
    LRUCacheLinkedList(int capacity){
        this.cap=capacity;
        this.cache=new LinkedList<E>();
    }

    public void put(E value){
        if (cache.size()<cap){
            cache.addFirst(value);
        }else {
            cache.removeLast();
            cache.addFirst(value);
        }
    }

    public E get(int index){
        E e=cache.get(index);
        cache.remove(e);
        cache.addFirst(e);
        return e;
    }

    @Override
    public String toString(){
        return cache.toString();
    }

    public static void main(String[] args) {
        LRUCacheLinkedList<Integer> LruCache=new LRUCacheLinkedList<>(3);
        LruCache.put(2);
        LruCache.put(4);
        System.out.println(LruCache.get(1));
        LruCache.put(6);
        System.out.println(LruCache.toString());
    }
}
