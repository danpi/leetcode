package hot100.Sub1_hash;

import java.util.HashSet;
import java.util.Set;

/**
 * hot100.Sub1_hash
 * N3_longestConsecutive
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N3_longestConsecutive {
    //先遍历生成set
    //对于每一个num，如果num-1没有在set中出现，才进行递增统计
    //如果num-1已经在set中，跳过（剪枝，选取最小值进行统计）
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) { //以num开始，连续的序列长度
                int curNum = num;
                int length = 1;
                while (set.contains(curNum + 1)) {
                    curNum = curNum + 1;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
