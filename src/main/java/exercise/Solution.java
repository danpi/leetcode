package exercise;

import common.ListNode;
import common.TreeNode;
import framework_ch1.slidingWindow.CheckInclusion;
import java.lang.reflect.Array;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import javax.annotation.processing.SupportedSourceVersion;

public class Solution {
    private LinkedList<Integer> bList;
    private static final int modk = 1337;

    public int superPow(int a, int[] b) {
        this.bList = new LinkedList<>();
        for (int v : b) {
            bList.addLast(v);
        }
        return pow(a);
    }

    private int pow(int a) {
        if (bList.isEmpty()) {
            return 1;
        }
        int lastV = bList.getLast();
        bList.removeLast();
        int part1 = singleBitPow(a, lastV);
        int part2 = singleBitPow(pow(a), 10);
        return (part1 * part2) % modk;
    }

    int singleBitPow(int a, int k) {
        a %= modk;
        int sum = 1;
        for (int i = 0; i < k; i++) {
            sum = sum * a;
            sum = sum % modk;
        }
        return sum;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (canFinish(piles, mid, h)) {
                right = mid;
                if (left == right) {
                    return left;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    boolean canFinish(int[] piles, int speed, int h) {
        for (int v : piles) {
            int time = v / speed + (v % speed == 0 ? 0 : 1);
            h -= time;
            if (h < 0) {
                return false;
            }
        }
        return true;
    }

    int getMax(int[] piles) {
        int maxV = 0;
        for (int v : piles) {
            if (v > maxV) {
                maxV = v;
            }
        }
        return maxV;
    }

    public int shipWithinDays(int[] weights, int day) {
        int left = getMax(weights), right = getSum(weights) + 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (canShip(weights, mid, day)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canShip(int[] weights, int load, int day) {
        int rest = load;
        for (int weight : weights) {
            if (rest >= weight) {
                rest -= weight;
            } else {
                rest = load - weight;
                day -= 1;
                if (day <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    public int trap(int[] height) {
        int count = 0;
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(height[i], lmax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i], rmax[i + 1]);
        }
        for (int i = 1; i < n - 2; i++) {
            count += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 1, 1, 2, 1};
        solution.canShip(nums, 12, 5);
        System.out.println(solution.trap(nums));
    }
}