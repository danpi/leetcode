package hot100.Sub16_多维动规;

/**
 * hot100.Sub16_multiDP
 * N2_minPathSum
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N2_minPathSum {
    // dp[i,j]:(i,j)处的最小和
    // dp[i,j]=min(dp[i-1,j],dp[i,j-1])+num(i,j)
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
