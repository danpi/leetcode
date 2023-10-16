package hot100.Sub15_动规;

import java.util.Arrays;

/**
 * hot100.Sub15_dp
 * N5_coinChange
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N5_coinChange {
    //dp[i]: 总金额为i时，需要的最少硬币个数
    //dp[i]=min(dp[i],dp[i-coin]+1)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
