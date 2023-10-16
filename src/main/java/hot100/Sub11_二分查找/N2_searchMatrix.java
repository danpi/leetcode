package hot100.Sub11_二分查找;

/**
 * hot100.Sub11_binarySearch
 * N2_searchMatrix
 *
 * @author hbn
 * @date 2023/10/12
 */

public class N2_searchMatrix {
    //降成一维的二分搜索即可
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] > target) {
                right = mid - 1;
            } else if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
