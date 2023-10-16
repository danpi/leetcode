package hot100.Sub4_子串;

import java.util.HashMap;
import java.util.Map;

/**
 * hot100.Sub4_subString
 * N3_minWindow
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N3_minWindow {
    //经典滑动窗口思路
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }
            while (valid == need.size()) {  //收缩左侧，同时更新len
                if (right - left <= len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
