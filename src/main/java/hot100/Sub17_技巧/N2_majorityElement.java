package hot100.Sub17_技巧;

/**
 * hot100.Sub17_skill
 * N2_majorityElement
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N2_majorityElement {
    //要满足时间O(n)，空间O(1)，思路很巧妙
    //假设当前数字为众数x，如果num==x,+1，否则-1
    //每当vote=0时，说明前面的众数和普通数一一抵消，可以忽略前面，选择当前数为众数
    //最后剩下的就是众数
    public int majorityElement(int[] nums) {
        int vote = 0;
        int x = 0;
        for (int num : nums) {
            if (vote == 0) {
                x = num;
            }
            vote = x == num ? vote + 1 : vote - 1;
        }
        return x;
    }

    //进阶版，nums中可能没有众数，最后需要做一下判断
    public int majorityElement2(int[] nums) {
        int vote = 0;
        int x = 0;
        for (int num : nums) {
            if (vote == 0) {
                x = num;
            }
            vote = x == num ? vote + 1 : vote - 1;
        }
        //判断x的频次是否>n/2
        int count = 0;
        for (int num : nums) {
            if (x == num) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : 0;
    }
}
