package hot100.Sub14_贪心;

import java.util.*;

/**
 * hot100.Sub14_greedy
 * N4_partitionLabels
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N4_partitionLabels {
    //用类似滑动窗口的思路解决
    //第一遍统计每个字母的频次；然后当前字母的频次==全部频次后，且维护一个valid记录还需要符合频次的个数。
    public List<Integer> partitionLabels(String s) {
        List<Integer> part = new LinkedList<>();
        Map<Character, Integer> kf = new HashMap<>();
        for (char ch : s.toCharArray()) {
            kf.put(ch, kf.getOrDefault(ch, 0) + 1);
        }
        int levelStart = 0;
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!window.containsKey(cur)) {
                valid++;
            }
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if (window.get(cur).equals(kf.get(cur)) && --valid == 0) {
                int len = i - levelStart + 1;
                part.add(len);
                levelStart = i + 1;
            }
        }
        return part;
    }

    //第一轮记录每个元素最后一次出现的位置
    //end来标识本轮最后的位置，不断更新
    //如果end==i,说明本轮结束
    public List<Integer> partitionLabels2(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<Integer>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']); //维护当前区间内所有元素最后一次出现最靠后的位置
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N4_partitionLabels partitionLabels = new N4_partitionLabels();
        System.out.println(partitionLabels.partitionLabels2("abcaabcdef"));
    }
}
