package framework.dp.subject;

public class N11_MaxA {
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[n];
    }
}
//https://leetcode.cn/problems/4-keys-keyboard/