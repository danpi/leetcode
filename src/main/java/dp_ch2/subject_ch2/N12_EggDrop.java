package dp_ch2.subject_ch2;

import java.util.HashMap;
import java.util.Map;

public class N12_EggDrop {
    Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        String key = k + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = Integer.MAX_VALUE;
        int left = 1, right = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int broken = dp(k - 1, mid - 1);
            int not_broken = dp(k, n - mid);
            if (broken > not_broken) {
                right = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                left = mid + 1;
                res = Math.min(res, not_broken + 1);
            }
        }
        memo.put(key, res);
        return res;
    }
}
//https://leetcode.cn/problems/super-egg-drop/
//好的解法：https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/solution/java-dong-tai-gui-hua-de-di-gui-xie-fa-t-6cvy/
