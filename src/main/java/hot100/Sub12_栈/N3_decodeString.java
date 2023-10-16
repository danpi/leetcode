package hot100.Sub12_栈;

/**
 * hot100.Sub12_stack
 * N3_decodeString
 *
 * @author hbn
 * @date 2023/10/14
 */

/**
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 */
public class N3_decodeString {
    private String src;
    private int index;

    public String decodeString(String s) {
        this.src = s;
        this.index = 0;
        return getString();
    }

    private String getString() {
        if (index == src.length() || src.charAt(index) == ']') {
            return "";
        }
        String res = "";
        char cur = src.charAt(index);
        int count = 1;
        if (Character.isDigit(cur)) {
            count = getCount();
            index++;    //跳过'['
            String str = getString();
            index++;    //注意跳过']'
            while (count-- > 0) {
                res += str;
            }
        } else if (Character.isLetter(cur)) {
            res = String.valueOf(cur);
            index++;
        }

        return res + getString();
    }

    private int getCount() {
        int count = 0;
        while (index < src.length() && Character.isDigit(src.charAt(index))) {
            count = count * 10 + src.charAt(index) - '0';
            index++;
        }
        return count;
    }

    public static void main(String[] args) {
        N3_decodeString decodeString = new N3_decodeString();
        String s = "3[a]2[bc]";
        System.out.println(decodeString.decodeString(s));
    }
}
