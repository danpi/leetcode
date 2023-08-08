import common.TreeNode;
import exercise.Solution;
import interview_ch5.N2_mod;
import interview_ch5.N3_binarySearch;
import interview_ch5.N8_intervalSchedule;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import structrue_ch3.N5_codec;
import thinking_ch4.N1_subset;
import thinking_ch4.N6_nsum;

/**
 * PACKAGE_NAME
 * main
 *
 * @author hbn
 * @date 2022/4/5
 */

public class Main {
    static char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    public static void main(String[] args) {
        Solution solution = new Solution();
       // System.out.println(solution.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
    }
}
