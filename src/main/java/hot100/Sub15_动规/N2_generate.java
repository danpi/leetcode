package hot100.Sub15_动规;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * hot100.Sub15_dp
 * N2_generate
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N2_generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curRow.add(1);
                } else {
                    curRow.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(curRow);
        }
        return res;
    }

    public static void main(String[] args) {
        N2_generate generate = new N2_generate();
        System.out.println(generate.generate(3));
    }
}
