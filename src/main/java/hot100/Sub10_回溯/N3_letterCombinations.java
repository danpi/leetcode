package hot100.Sub10_回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hot100.Sub10_回溯
 * N3_letterCombinations
 *
 * @author hbn
 * @date 2023/10/16
 */

public class N3_letterCombinations {
    private List<String> res=new ArrayList<>();
    private Map<Character,String> phoneMap;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        }
        phoneMap=new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        StringBuilder path=new StringBuilder();
        backtrack(digits,path,0);
        return res;
    }
    void backtrack(String digits,StringBuilder path,int index){
        if (index==digits.length()){
            res.add(path.toString());
            return;
        }
        for (char ch:phoneMap.get(digits.charAt(index)).toCharArray()){
            path.append(ch);
            backtrack(digits,path,index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
