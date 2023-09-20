package interview_ch5;

//https://leetcode.cn/problems/trapping-rain-water/
public class N9_Trap {
    public int getMaxRain(int[] heights) {
        if (heights==null||heights.length==0){
            return -1;
        }
        int n = heights.length;
        int count = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        for (int i = 0; i < n; i++) {
            count += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return count;
    }

    public static void main(String[] args) {
        N9_Trap maxRain = new N9_Trap();
        int[] heights = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(maxRain.getMaxRain(heights));
    }
}
