package thinking_ch4;

public class N2_isValidSudoku {
    //https://leetcode.cn/problems/valid-sudoku/
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if(ch!='.') {
                    int index = ch - '0' - 1;
                    row[i][index]++;
                    col[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || col[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
