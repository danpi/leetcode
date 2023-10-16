package hot100.Sub2_双指针;

/**
 * hot100.Sub2_doublepointer
 * N4_trap
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N4_trap {
    //lmax[i]为height[i]的左边界最大值，rmax同理
    //对于i来说，如果height[i]比左右边界都大，那么i中接不到水
    public int trap(int[] height) {
        int[] lmax=new int[height.length];
        int[] rmax=new int[height.length];
        lmax[0]=height[0];
        for(int i=1;i<height.length;i++){
            lmax[i]=Math.max(lmax[i-1],height[i]);
        }
        rmax[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rmax[i]=Math.max(rmax[i+1],height[i]);
        }
        int area=0;
        for(int i=1;i<height.length-1;i++){
            int h= Math.min(lmax[i],rmax[i])-height[i];
            area+=h;
        }
        return area;
    }
}
