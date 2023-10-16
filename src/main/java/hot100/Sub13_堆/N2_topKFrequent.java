package hot100.Sub13_堆;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * hot100.Sub13_heap
 * N2_topKFrequent
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N2_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> kf = new HashMap<>();
        for (int num : nums) {
            kf.put(num, kf.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return kf.get(o1) - kf.get(o2);
            }
        });
        for (Integer key : kf.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(key);
            } else if (kf.get(minHeap.peek()) < kf.get(key)) {
                minHeap.remove();
                minHeap.add(key);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll();
        }
        return res;
    }
}
