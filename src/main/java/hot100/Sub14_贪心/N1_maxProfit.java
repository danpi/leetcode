package hot100.Sub14_贪心;

/**
 * hot100.Sub14_greedy
 * N1_maxProfit
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N1_maxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }
}
