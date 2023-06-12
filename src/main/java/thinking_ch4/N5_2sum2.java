package thinking_ch4;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.cn/problems/two-sum-iii-data-structure-design/
public class N5_2sum2 {
    private Map<Integer, Integer> kf;

    public N5_2sum2() {
        this.kf = new HashMap<>();
    }

    public void add(int number) {
        kf.put(number, kf.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (int key : kf.keySet()) {
            int rest = value - key;
            if (rest == key && kf.get(key) > 1) {
                return true;
            }
            if (rest != key && kf.containsKey(rest)) {
                return true;
            }
        }
        return false;
    }
}
