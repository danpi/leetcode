package hot100.Sub10_回溯;

/**
 * hot100.Sub10_回溯
 * N6_exist
 *
 * @author hbn
 * @date 2023/10/16
 */

public class N6_exist {
    public boolean exist(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, wordChars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, char[] wordChars, int r, int c, int index) {
        if (r >= board.length || r < 0 || c >= board[0].length || c < 0 || board[r][c] != wordChars[index]) {
            return false;
        }
        if (index == wordChars.length - 1) return true;
        board[r][c] = '\0';
        boolean res = backtrack(board, wordChars, r + 1, c, index + 1) || backtrack(board, wordChars, r, c + 1, index + 1) ||
                backtrack(board, wordChars, r - 1, c, index + 1) || backtrack(board, wordChars, r, c - 1, index + 1);
        board[r][c] = wordChars[index];
        return res;
    }
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     */
}
