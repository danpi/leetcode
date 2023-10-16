package hot100.Sub6_矩阵;

/**
 * hot100.Sub6_matrix
 * N4_searchMatrix
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N4_searchMatrix {
    //Z子查找，O(m+n)
    //从右上角开始查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
