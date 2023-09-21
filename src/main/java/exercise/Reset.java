package exercise;

import java.util.Arrays;
import java.util.Random;

public class Reset {
    int[] original;
    int[] nums;

    public Reset(int[] nums) {
        this.nums = nums;
        this.original = Arrays.copyOfRange(nums, 0, nums.length);
    }

    public int[] reset() {
        return Arrays.copyOfRange(this.original, 0, this.original.length);
    }

    public int[] shuffle() {
        Random rand = new Random();
        for (int i = 0; i < this.nums.length; i++) {
            int j = i + rand.nextInt(nums.length - i);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return this.nums;
    }
}
