package framework_ch1.slidingWindow;

import java.util.HashMap;
import java.util.Map;
//字符串的排列
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char curC = s2.charAt(right);
            right++;
            if (need.containsKey(curC)) {
                window.put(curC, window.getOrDefault(curC, 0) + 1);
                if (window.get(curC).equals(need.get(curC))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char leftC = s2.charAt(left);
                left++;
                if (need.containsKey(leftC)) {
                    if (window.get(leftC) == need.get(leftC)) {
                        valid--;
                    }
                    window.put(leftC, window.get(leftC) - 1);
                }
            }
        }
        return false;
    }
}
//https://leetcode.cn/problems/permutation-in-string/