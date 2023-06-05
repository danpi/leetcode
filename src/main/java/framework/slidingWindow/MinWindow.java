package framework.slidingWindow;

import java.util.HashMap;
import java.util.Map;

//最小覆盖子串
public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char curC = s.charAt(right);
            right++;
            if (need.containsKey(curC)) {
                window.put(curC, window.getOrDefault(curC, 0) + 1);
                if (window.get(curC).equals(need.get(curC))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char leftC = s.charAt(left);
                left++;
                if (need.containsKey(leftC)) {
                    if (window.get(leftC) == need.get(leftC)) {
                        valid--;
                    }
                    window.put(leftC, window.get(leftC) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//https://leetcode.cn/problems/minimum-window-substring/