package framework.slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//寻找所有的字母异位词
public class FindAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char curC = s.charAt(right);
            right++;
            if (need.containsKey(curC)) {
                window.put(curC, window.getOrDefault(curC, 0) + 1);
                if (window.get(curC).equals(need.get(curC))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char leftC = s.charAt(left);
                left++;
                if (need.containsKey(leftC)) {
                    if (need.get(leftC).equals(window.get(leftC))) {
                        valid--;
                    }
                    window.put(leftC, window.get(leftC) - 1);
                }
            }
        }
        return res;
    }
}
//https://leetcode.cn/problems/find-all-anagrams-in-a-string/