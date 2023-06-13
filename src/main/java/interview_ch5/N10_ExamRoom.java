package interview_ch5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//https://leetcode.cn/problems/exam-room/
public class N10_ExamRoom {
    private TreeSet<int[]> pq;
    private Map<Integer, int[]> startMap;
    private Map<Integer, int[]> endMap;
    private int n;

    public N10_ExamRoom(int n) {
        this.n = n;
        this.startMap = new HashMap<>();
        this.endMap = new HashMap<>();
        this.pq = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = distance(o1);
                int dist2 = distance(o2);
                if (dist1 == dist2) {
                    return o2[0] - o1[0];
                }
                return dist1 - dist2;
            }
        });
        addInterval(new int[]{-1, this.n});
    }

    private void removeInterval(int[] segment) {
        this.pq.remove(segment);
        this.startMap.remove(segment[0]);
        this.endMap.remove(segment[1]);
    }

    private void addInterval(int[] segment) {
        this.pq.add(segment);
        this.startMap.put(segment[0], segment);
        this.endMap.put(segment[1], segment);
    }

    private int distance(int[] segment) {
        int x = segment[0];
        int y = segment[1];
        if (x == -1) {
            return y;
        }
        if (y == this.n) {
            return this.n - 1 - x;
        }
        return (y - x) / 2;
    }

    public int seat() {
        int seat;
        int[] longest = this.pq.last();
        int x = longest[0];
        int y = longest[1];
        if (x == -1) {
            seat = 0;
        } else if (y == this.n) {
            seat = this.n - 1;
        } else {
            seat = (y - x) / 2 + x;
        }
        int[] left = new int[]{x, seat};
        int[] right = new int[]{seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {
        int[] left = endMap.get(p);
        int[] right = startMap.get(p);
        int[] merged = new int[]{left[0], right[1]};
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }
}
