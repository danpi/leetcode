package hot100.Sub2_双指针;

/**
 * hot100.Sub2_doublepointer
 * N2_maxArea
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N2_maxArea {
    //左右指针夹逼，左右边界中谁的值比较小，谁缩进
    //有点贪心的思想
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int maxArea=0;
        while(left<right){
            int area=(right-left)*Math.min(height[left],height[right]);
            maxArea=Math.max(area,maxArea);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
