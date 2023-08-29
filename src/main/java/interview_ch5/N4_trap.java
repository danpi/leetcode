package interview_ch5;

//https://leetcode.cn/problems/trapping-rain-water/
public class N4_trap {
    public int trap(int[] height) {
        int count = 0;
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(height[i], lmax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i], rmax[i + 1]);
        }
        for (int i = 1; i < n - 2; i++) {
            count += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return count;
    }
}
