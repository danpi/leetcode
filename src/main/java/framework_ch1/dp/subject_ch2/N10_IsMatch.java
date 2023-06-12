package framework_ch1.dp.subject_ch2;

import java.util.HashMap;
import java.util.Map;

public class N10_IsMatch {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    boolean dp(String s, int i, String p, int j) {
        //终止条件
        if (j == p.length()) {
            return i == s.length();
        }
        if (i == s.length()) {
            if ((p.length() - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < p.length(); j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        //记录状态
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            //匹配
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                //通配符匹配0或多次
                return dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                //常规匹配
                return dp(s, i + 1, p, j + 1);
            }
        } else {
            //不匹配
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                //跳过通配符
                return dp(s, i, p, j + 2);
            } else {
                //失败
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }
}
