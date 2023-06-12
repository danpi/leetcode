package structrue_ch3;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

//https://leetcode.cn/problems/lfu-cache/
public class N2_LFUCache {
    private int capacity;
    private int minFreq;
    Map<Integer, Integer> kv;
    Map<Integer, Integer> kf;
    Map<Integer, LinkedHashSet<Integer>> fk;

    public N2_LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.kv = new HashMap<>();
        this.kf = new HashMap<>();
        this.fk = new HashMap<>();
    }

    public int get(int key) {
        if (!kv.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return kv.get(key);
    }

    public void put(int key, int value) {
        if (kv.containsKey(key)) {
            kv.put(key, value);
            increaseFreq(key);
            return;         /** 注意，总是忘记直接return **/
        }
        //full
        if (kv.size() >= this.capacity) {
            removeMinFreqKey();
        }
        kv.put(key, value);
        kf.put(key, 1);
        fk.putIfAbsent(1, new LinkedHashSet<>());
        fk.get(1).add(key);
        this.minFreq = 1;
    }

    public void increaseFreq(int key) {
        //delete old kf; update new kf,fk; update minFreq
        int freq = kf.get(key);
        fk.get(freq).remove(key);
        kf.put(key, freq + 1);
        fk.putIfAbsent(freq + 1, new LinkedHashSet<>());
        fk.get(freq + 1).add(key);
        if (fk.get(freq).isEmpty()) {
            fk.remove(freq);
            if (freq == this.minFreq) {     /** 注意此处的判断，更新minFreq的时机 **/
                this.minFreq = freq + 1;
            }
        }
    }

    public void removeMinFreqKey() {
        //update kv,kf,fk; update minFreq?
        LinkedHashSet<Integer> minKeyList = fk.get(this.minFreq);
        Integer deleteKey = minKeyList.iterator().next();
        minKeyList.remove(deleteKey);
        if (minKeyList.isEmpty()) {
            fk.remove(this.minFreq);
        }
        kv.remove(deleteKey);
        kf.remove(deleteKey);

    }
}
