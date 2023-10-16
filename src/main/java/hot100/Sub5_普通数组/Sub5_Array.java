package hot100.Sub5_普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * hot100
 * N5_Array
 *
 * @author hbn
 * @date 2023/10/8
 */

public class Sub5_Array {
    //1
    //dp[i]：以i为结尾的最大和
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;

    }

    //2
    //先排序，然后遍历排序后的数组
    //L和R为i的区间，如果res的末尾右区间<L,将cur添加近res
    //否则合并区间，res的末尾左侧不变，右侧=max(原右侧,R)
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < L) {
                res.add(new int[]{L, R});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    //3
    //反转三次即可，(0,n-1) (0,k-1) (k,n-1)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            start++;
            end--;
        }
    }

    //4 O(n)
    //维护两个数组L，R
    //L[i]是前i个数字乘积
    //mul[i]=L[i]*R[i];
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        int[] ans = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = R * ans[i];
            R = R * nums[i];
        }
        return ans;
    }

    //5
    //对数组进行恢复，[3, 4, -1, 1]恢复后为 [1, -1, 3, 4]
    //数字x=1，应该在数组第一个位置上，即1=num[0] ===> num[num[i]-1]==num[i]
    //遍历恢复后的数组，第一个不符合预期的值就是缺失的
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
