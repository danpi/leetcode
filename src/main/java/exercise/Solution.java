package exercise;

import common.ListNode;
import common.TreeNode;
import framework_ch1.slidingWindow.CheckInclusion;
import java.lang.reflect.Array;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import javax.annotation.processing.SupportedSourceVersion;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadNumbers = new HashSet<>();
        for (String deadNumber : deadends) {
            deadNumbers.add(deadNumber);
        }

        String start = "0000";
        q.add(start);
        visited.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (deadNumbers.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                for (int index = 0; index < 4; index++) {
                    String plusStr = plusOne(cur, index);
                    if (visited.contains(plusStr)) {
                        q.offer(plusStr);
                        visited.add(plusStr);
                    }
                    String minusStr = minusOne(cur, index);
                    if (visited.contains(minusStr)) {
                        q.offer(minusStr);
                        visited.add(minusStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    String plusOne(String cur, int index) {
        char[] curChars = new char[cur.length()];
        if (curChars[index] == '9') {
            curChars[index] = '0';
        } else {
            curChars[index] += 1;
        }
        return new String(curChars);
    }

    String minusOne(String cur, int index) {
        char[] curChars = new char[cur.length()];
        if (curChars[index] == '0') {
            curChars[index] = '9';
        } else {
            curChars[index] -= 1;
        }
        return new String(curChars);
    }
}