package structrue_ch3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LFUCache {
    Map<Integer, Integer> kv;
    Map<Integer, Integer> kf;
    Map<Integer, LinkedList<Integer>> fk;
    private int capacity;
    int size = 0;
    int minFreq = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.kv = new HashMap<>();
        this.kf = new HashMap<>();
        this.fk = new HashMap<>();
    }

    public int get(int key) {
        if (!kv.containsKey(key)) {
            return -1;
        }
        int value = kv.get(key);
        updateFreq(key);
        return value;
    }

    public void put(int key, int value) {
        if (kv.containsKey(key)) {
            kv.put(key, value);
            updateFreq(key);
            return;
        }
        if (size >= capacity) {
            removeMinFreqKey();
        }
        kv.put(key, value);
        kf.put(key, 1);
        fk.putIfAbsent(1, new LinkedList<>());
        fk.get(1).addLast(key);
        this.minFreq = 1;
    }

    private void updateFreq(int key) {
        int freq = kf.get(key);
        kf.put(key, freq + 1);
        fk.get(freq).remove(key);
        fk.putIfAbsent(freq + 1, new LinkedList<>());
        fk.get(freq + 1).add(key);
        if (fk.get(freq).isEmpty()) {
            fk.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq = freq + 1;
            }
        }
    }

    private void removeMinFreqKey() {
        LinkedList<Integer> keyList = fk.get(this.minFreq);
        int key = keyList.removeFirst();
        if (keyList.isEmpty()) {
            fk.remove(this.minFreq);
        }
        kv.remove(key);
        kf.remove(key);
    }
}
