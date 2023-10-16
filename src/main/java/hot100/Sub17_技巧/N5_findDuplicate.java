package hot100.Sub17_技巧;

/**
 * hot100.Sub17_skill
 * N5_findDuplicate
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N5_findDuplicate {
    // 因为数字范围是[1,n]，所以i->nums[i]一定还在数组范围内
    // 快慢指针，n->f(n),如果有重复，那么有环
    //slow=slow.next等价于slow=nums[slow];
    //fast=fast.next.next等价于fast=nums[nums[fast]]
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
