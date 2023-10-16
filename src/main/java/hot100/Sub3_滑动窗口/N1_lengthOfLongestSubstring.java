package hot100.Sub3_滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * hot100.Sub3_slidingWindows
 * N1_lengthOfLongestSubstring
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N1_lengthOfLongestSubstring {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window=new HashMap<>();
        int left=0,right=0;
        int maxLen=0;
        while(right<s.length()){
            char cur=s.charAt(right);
            right++;
            window.put(cur, window.getOrDefault(cur,0)+1);
            while(window.get(cur)>1){   //收缩左侧
                char deleteCh=s.charAt(left);
                left++;
                window.put(deleteCh,window.get(deleteCh)-1);
            }
            maxLen=Math.max(maxLen,right- left);
        }
        return maxLen;
    }
}
