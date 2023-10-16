package hot100.Sub6_矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hot100.Sub6_matrix
 * N2_spiralOrder
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N2_spiralOrder {
    //维护左右上下边界，不断从左到右，从上到下，从右到左，从下到上
    //且不断更新l,r,t,b，直到超过边界后，退出循环
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        Integer[] res = new Integer[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top
            if (++l > r) break;
        }
        return Arrays.asList(res);
    }
}
