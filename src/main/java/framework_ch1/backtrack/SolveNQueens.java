package framework_ch1.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(buildBoard(board));
            return;
        }
        int n = board.length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    //只返回一种解法即可
    private boolean backtrackOne(char[][] board, int row) {
        if (row == board.length) {
            res.add(buildBoard(board));
            return true;
        }
        int n = board.length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            if (backtrackOne(board, row + 1)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> buildBoard(char[][] board) {
        List<String> solve = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solve.add(new String(board[i]));
        }
        return solve;
    }

    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(4));
    }
}
