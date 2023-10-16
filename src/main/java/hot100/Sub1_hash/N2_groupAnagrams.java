package hot100.Sub1_hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hot100.Sub1_hash
 * N2_groupAnagrams
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N2_groupAnagrams {
    //res: key(按字母序排列的字符串) value(同样key对应的异位词)
    //对于每个key，统计每个字母的频次，然后字母按顺序组合成key，同key的异位词被放在一起
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res=new HashMap<>();
        for(String str:strs){
            int[] count=new int[26];
            for(char ch: str.toCharArray()){
                count[ch-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++){
                if(count[i]!=0){
                    sb.append(count[i]);
                    sb.append(i+'a');
                }
            }
            String key=sb.toString();
            List<String> list=res.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            res.put(key,list);
        }
        return new ArrayList<>(res.values());

    }
}
