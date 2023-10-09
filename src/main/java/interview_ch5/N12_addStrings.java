package interview_ch5;

/**
 * interview_ch5
 * N12_addStrings
 *
 * @author hbn
 * @date 2023/10/7
 */

public class N12_addStrings {
    public String addStrings(String num1, String num2) {
        int n1Index = num1.length() - 1, n2Index = num2.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();
        while (n1Index >= 0 || n2Index >= 0 || carry != 0) {
            int n1Value = n1Index >= 0 ? num1.charAt(n1Index) - '0' : 0;
            int n2Value = n2Index >= 0 ? num2.charAt(n2Index) - '0' : 0;
            int res = n1Value + n2Value + carry;
            ans.append(res % 10);
            carry = res / 10;
            n1Index--;
            n2Index--;
        }
        ans.reverse();
        return ans.toString();
    }

    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        String ans = "";
        StringBuilder tempRes;
        int zeroNumber = 0;
        int carry = 0;
        int bit1, bit2, curBit;
        for (int i = n2 - 1; i >= 0; i--) {
            carry = 0;
            tempRes = new StringBuilder();
            zeroNumber = n2 - 1 - i;

            bit2 = num2.charAt(i) - '0';
            int j = n1 - 1;
            while (zeroNumber-- > 0) {
                tempRes.append('0');
            }
            while (j >= 0 || carry != 0) {
                bit1 = j < 0 ? 0 : (num1.charAt(j) - '0');
                curBit = (bit1 * bit2 + carry);
                carry = curBit / 10;
                tempRes.append(curBit % 10);
                j--;
            }
            tempRes.reverse();
            ans = addStrings(ans, tempRes.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        N12_addStrings n12_addStrings = new N12_addStrings();
        //System.out.append(n12_addStrings.addStrings("123", "456"));
        System.out.println(n12_addStrings.multiply("123", "45"));
    }
}
