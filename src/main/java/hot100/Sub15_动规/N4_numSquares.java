package hot100.Sub15_动规;

/**
 * hot100.Sub15_dp
 * N4_numSquares
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N4_numSquares {
    //dp[i]：数字为i时，需要的最少个数
    //dp[i]=min(dp[i],dp[i-j*j]+1)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j=1;i-j*j>=0;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
