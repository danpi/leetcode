package hot100.Sub16_多维动规;

/**
 * hot100.Sub16_multiDP
 * N3_longestPalindrome
 *
 * @author hbn
 * @date 2023/10/15
 */

public class N3_longestPalindrome {
    //中心扩散，注意奇偶
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String oddStr = palindrome(s, i, i);
            String evenStr = palindrome(s, i, i + 1);
            res = res.length() < oddStr.length() ? oddStr : res;
            res = res.length() < evenStr.length() ? evenStr : res;
        }
        return res;
    }

    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
