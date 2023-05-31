package sort;

public class Sorts {
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean breakFlag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    breakFlag = false;
                }
            }
            if (breakFlag) {
                break;
            }
        }
    }

    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int value = a[i];
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];    //移动数据
                } else {
                    break;
                }
            }
            a[j + 1] = value;   //插入数据
        }
    }
}
