package exercise;

import common.ListNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int len = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            while (window.get(ch) > 1) {
                char leftC = s.charAt(left);
                left++;
                window.put(leftC, window.get(leftC) - 1);
            }
            len = Math.max(len, right - left);
        }
        return len;
    }

    void slidingWindow(String s, String sub) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : sub.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            //取出当前字符，并右移
            char cur = s.charAt(right);
            right++;
            //更新窗口
            if (need.containsKey(cur)) {

            }
            //判断是否要收缩
            while (window needs shrink){
                //判断是否满足
                if (valid == need.size()) {
                    return xxx;
                }
                char leftC = s.charAt(left);
                left++;
                //更新窗口
                if (need.containsKey(leftC)) {

                }
            }
        }
    }
}
