package framework_ch1.doublepointer;

public class Reverse {
    public void reverse(int[] nums){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }

    }
}
