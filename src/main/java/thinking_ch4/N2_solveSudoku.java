package thinking_ch4;

public class N2_solveSudoku {
    private int m, n;
    //https://leetcode.cn/problems/sudoku-solver/submissions/
    public void solveSudoku(char[][] board) {
        m = n = board.length;
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        if (j == m) {
            //下一行
            return backtrack(board, i + 1, 0);
        }
        if (i == n) {
            //i=8,j=8之后为i=9,j=0，此时意味着有可行解
            return true;
        }
        if (board[i][j] != '.') {
            //有预设数字，对下一位穷举
            return backtrack(board, i, j + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            //不合法数字，跳过
            if (!isValidCur(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            //有一个可行解，就尝试返回
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        //当前格子1-9，没有可行解，换个格子继续
        return false;
    }

    private boolean isValidCur(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == ch) {
                return false;
            }
            if (board[i][c] == ch) {
                return false;
            }
            if (board[(r / 3) * 3 + i / 3][(c / 3 * 3) + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}
