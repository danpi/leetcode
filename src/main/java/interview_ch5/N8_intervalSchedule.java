package interview_ch5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import sort.Sorts;

public class N8_intervalSchedule {
    public int intervalSchedule(int[][] intvs) {
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = intvs[0][1];
        for (int i = 1; i < intvs.length; i++) {
            if (intvs[i][0] >= end) {
                end = intvs[i][1];
                count++;
            }
        }
        return count;
    }

    //https://leetcode.cn/problems/non-overlapping-intervals/
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    //https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                count++;
            }
        }
        return count;
    }
}
