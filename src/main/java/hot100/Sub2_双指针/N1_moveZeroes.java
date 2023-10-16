package hot100.Sub2_双指针;

/**
 * hot100.Sub2_doublepointer
 * N1_moveZeroes
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N1_moveZeroes {
    //nonZeroIndex记录非0的偏移
    //最后再将剩余的置0
    public void moveZeroes(int[] nums) {
        int nonZeroIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[nonZeroIndex++]=nums[i];
            }
        }
        for(int i=nonZeroIndex;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
