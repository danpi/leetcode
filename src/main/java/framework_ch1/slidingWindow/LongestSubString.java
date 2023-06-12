package framework_ch1.slidingWindow;

import java.util.HashMap;
import java.util.Map;

//最长无重复子串
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        while (right < s.length()) {
            char curC = s.charAt(right);
            right++;
            window.put(curC, window.getOrDefault(curC, 0) + 1);
            while (window.get(curC) > 1) {
                char leftC = s.charAt(left);
                left++;
                window.put(leftC, window.get(leftC) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
//https://leetcode.cn/problems/longest-substring-without-repeating-characters/
/*
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */