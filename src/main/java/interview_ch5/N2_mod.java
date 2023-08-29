package interview_ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.cn/problems/super-pow/
public class N2_mod {
    /**
     * @param a 1<=a<=2^31-1
     * @param b 非常大，不能用数字表示
     * @return 直接对k取模的话会溢出
     * (a*b)%k=[(a%k)*(b%k)]%k
     */
    private LinkedList<Integer> bList;
    private final int mod = 1337;

    public int superPow(int a, int[] b) {
        bList = new LinkedList<>();
        for (int v : b) {
            bList.addLast(v);
        }
        return pow(a);
    }

    private int pow(int a) {
        if (bList.isEmpty()) {
            return 1;
        }
        int last = bList.removeLast();
        int part1 = powMod(a, last);
        int part2 = powMod(pow(a), 10);
        return (part1 * part2) % mod;
    }

    private int powMod(int a, int b) {
        a %= mod;
        int res = 1;
        for (int i = 0; i < b; i++) {
            res *= a;
            res %= mod;
        }
        return res;
    }

    //高效求幂运算
    public int powAB(int a, int k) {
        if (k == 0) {
            return 1;
        }
        if (k % 2 == 1) {
            //k为奇数
            return a * (powAB(a, k - 1));
        } else {
            int sub = powAB(a, k / 2);
            return sub * sub;
        }
    }

}
