package interview_ch5;

public class N3_binarySearch {
    //https://leetcode.cn/problems/koko-eating-bananas/
    //吃香蕉问题，可以用二分法进行优化
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles) + 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (canFinish(mid, piles, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int speed, int[] piles, int h) {
        long totalTime = 0;
        for (int pile : piles) {
            totalTime += timeWithSpeed(pile, speed);
        }
        if (totalTime <= h) {
            return true;
        }
        return false;
    }

    private int timeWithSpeed(int n, int speed) {
        return n / speed + (n % speed > 0 ? 1 : 0);
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (max < pile) {
                max = pile;
            }
        }
        return max;
    }

    //https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
    public int shipWithinDays(int[] weights, int days) {
        int left = getMaxWeight(weights);
        int right = getSumWeight(weights) + 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (canF(mid, days, weights)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canF(int cap, int days, int[] weights) {
        int i = 0;
        for (int day = 1; day <= days; day++) {
            int curCap = cap;
            while ((curCap -= weights[i]) >= 0) {
                i++;
                if (i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getMaxWeight(int[] weights) {
        int max = 0;
        for (int weight : weights) {
            if (max < weight) {
                max = weight;
            }
        }
        return max;
    }

    private int getSumWeight(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }
}
