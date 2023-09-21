package interview_ch5;

public class N9_bracket {
    public boolean isValid(String s) {
        int left = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else {
                left--;
            }
            if (left < 0) {
                return false;
            }
        }
        return true;
    }
}
