package hot100.Sub15_动规;

import java.util.HashSet;
import java.util.List;

/**
 * hot100.Sub15_dp
 * N6_wordBreak
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N6_wordBreak {
    //dp[i]: 以i为结尾的字符串是否符合
    //dp[i]=dp[j]+check(s[j,i])
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
