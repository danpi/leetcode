package framework_ch1.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> stringQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();

        stringQueue.offer("0000");
        visited.add("0000");
        for (String dead : deadends) {
            deads.add(dead);
        }
        int step = 0;

        while (!stringQueue.isEmpty()) {
            int sz = stringQueue.size();
            //expend
            for (int i = 0; i < sz; i++) {
                String cur = stringQueue.poll();
                //判断是否是终点
                if (cur.equals(target)) {
                    return step;
                }
                if (deads.contains(cur)) {
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        stringQueue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        stringQueue.offer(down);
                        visited.add(down);
                    }
                }
            }
            //增加步数
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int index) {
        char[] ch = s.toCharArray();
        if (ch[index] == '9') {
            ch[index] = '0';
        } else {
            ch[index] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String s, int index) {
        char[] ch = s.toCharArray();
        if (ch[index] == '0') {
            ch[index] = '9';
        } else {
            ch[index] -= 1;
        }
        return new String(ch);
    }
}

//https://leetcode.cn/problems/zlDJc7/
