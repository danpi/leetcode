package thinking_ch4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.cn/problems/sliding-puzzle/
public class N4_slidingPuzzle {

    /**
     * 最少步数一般用BFS,将二维数组降为一维
     */
    public int slidingPuzzle(int[][] board) {
        int m = 2;
        int n = 3;
        int[][] neighbor = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        System.out.println(neighbor.length);
        System.out.println(neighbor[0].length);
        StringBuilder start = new StringBuilder();
        String target = "123450";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start.append(board[i][j]);
            }
        }
        if (start.toString().equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                if (target.equals(cur)) {
                    return step;
                }
                int zeroIndex = cur.indexOf('0');
                for (int adj : neighbor[zeroIndex]) {
                    String newBoard = exchangeString(cur, adj, zeroIndex);
                    if (!visited.contains(newBoard)) {
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 交换字符
    public String exchangeString(String string, int src, int dis) {
        char[] chars = string.toCharArray();
        char temp = chars[dis];
        chars[dis] = chars[src];
        chars[src] = temp;
        return new String(chars);
    }
}
