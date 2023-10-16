package hot100.Sub15_动规;

/**
 * hot100.Sub15_dp
 * N10_longestValidParentheses
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N10_longestValidParentheses {
    //dp[i]:以i为下标结尾的最长有效括号，所以dp中只有')'结尾才有非0值
    //s[i]==')'&&s[i-1]=='('  dp[i]=dp[i-1]+2;
    //s[i]==')'&&s[i-1]==')'  dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i < 2 ? 0 : dp[i - 2]) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    int before = (i - dp[i - 1] < 2 ? 0 : dp[i - dp[i - 1] - 2]);
                    dp[i] = dp[i - 1] + before + 2;
                }
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }
    //https://leetcode.cn/problems/longest-valid-parentheses/solutions/314683/zui-chang-you-xiao-gua-hao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked

    public static void main(String[] args) {
        N10_longestValidParentheses demo = new N10_longestValidParentheses();
        demo.longestValidParentheses(")()())");
    }
}
