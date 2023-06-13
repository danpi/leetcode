import common.TreeNode;
import interview_ch5.N2_mod;
import interview_ch5.N3_binarySearch;
import interview_ch5.N8_intervalSchedule;
import structrue_ch3.N5_codec;
import thinking_ch4.N6_nsum;

/**
 * PACKAGE_NAME
 * main
 *
 * @author hbn
 * @date 2022/4/5
 */

public class Main {
    public static void main(String[] args) {
        N8_intervalSchedule ans = new N8_intervalSchedule();
        int[][] point = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(ans.findMinArrowShots(point));
    }
}
