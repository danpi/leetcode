package hot100.Sub16_多维动规;

/**
 * hot100.Sub16_multiDP
 * N1_uniquePaths
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N1_uniquePaths {
    // dp[i,j]: (i，j)处的路径条数
    // dp[i,j]=dp[i-1,j]+dp[i,j-1]
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
