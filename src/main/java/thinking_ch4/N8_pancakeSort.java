package thinking_ch4;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.cn/problems/pancake-sorting/
public class N8_pancakeSort {
    private List<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    private void sort(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        int maxCakes = 0, maxCakesIndex = 0;
        for (int i = 0; i < n; i++) {
            if (maxCakes < arr[i]) {
                maxCakes = arr[i];
                maxCakesIndex = i;
            }
        }
        //将当前最大值交换到头部
        reverse(arr, 0, maxCakesIndex);
        res.add(maxCakesIndex + 1);
        //将当前最大值交换到尾部
        reverse(arr, 0, n - 1);
        res.add(n);
        sort(arr, n - 1);
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
