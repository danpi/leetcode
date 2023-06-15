package interview_ch5;

//https://leetcode.cn/problems/trapping-rain-water/
public class N4_trap {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int[] h = new int[n + 2];
        h[0] = h[n + 1] = 0;
        for (int i = 0; i < n; i++) {
            h[i + 1] = height[i];
        }
        int[] lMax = new int[n + 2];
        int[] rMax = new int[n + 2];
        lMax[0] = 0;
        for (int i = 1; i < h.length; i++) {
            lMax[i] = Math.max(lMax[i - 1], h[i]);
        }
        rMax[n + 1] = h[n + 1];
        for (int i = n; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], h[i]);
        }
        for (int i = 1; i < h.length - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - h[i];
        }
        return res;
    }
}
