package hot100.Sub3_滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hot100.Sub3_slidingWindows
 * N2_findAnagrams
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N2_findAnagrams {
    //need中为p的字符统计，window为s的字符统计
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> window=new HashMap<>();
        Map<Character,Integer> need=new HashMap<>();
        for(Character ch:p.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        int left=0,right=0;
        int valid=0;
        while(right<s.length()){
            char cur=s.charAt(right);
            right++;
            if(need.containsKey(cur)){
                window.put(cur,window.getOrDefault(cur,0)+1);
                if(window.get(cur).equals(need.get(cur))){  // Integer是对象，所以要用equals来进行比较，如果使用==，当值>127时，不相等
                    valid++;
                }
            }
            while(right-left>=p.length()){  //判断结果，并收缩左侧
                if(valid==need.size()){ //符合异位词
                    res.add(left);
                }
                char deleteCh=s.charAt(left);
                left++;
                if(need.containsKey(deleteCh)){
                    if(need.get(deleteCh).equals(window.get(deleteCh))){
                        valid--;
                    }
                    window.put(deleteCh,window.get(deleteCh)-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N2_findAnagrams findAnagrams=new N2_findAnagrams();
        StringBuilder s=new StringBuilder();
        StringBuilder p=new StringBuilder();
        for (int i=0;i<10000;i++){
            s.append('a');
            p.append('a');
        }
        s.append('b');
        for (int i=0;i<10000;i++){
            s.append('a');
        }
        System.out.println(findAnagrams.findAnagrams(s.toString(),p.toString()));
    }
}
