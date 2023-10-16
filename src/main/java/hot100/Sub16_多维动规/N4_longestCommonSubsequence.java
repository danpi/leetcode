package hot100.Sub16_多维动规;

/**
 * hot100.Sub16_multiDP
 * N4_longestCommonSubsequence
 *
 * @author hbn
 * @date 2023/10/15
 */

//dp[i,j]:text1以i为结尾和text2以j为结尾的字符串，最大子序列长度
//求dp[m][n]
public class N4_longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
