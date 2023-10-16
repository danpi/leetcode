package hot100.Sub13_堆;

/**
 * hot100.N13_heap
 * N1_findKthLargest
 *
 * @author hbn
 * @date 2023/10/14
 */

public class N1_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickselect2(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int pivot = l;
        int index = pivot + 1;
        for (int i = index; i <= r; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        int partition = index - 1;
        if (partition == k) {
            return nums[partition];
        } else if (partition > k) {
            return quickSelect(nums, l, partition - 1, k);
        } else {
            return quickSelect(nums, partition + 1, r, k);
        }
    }

    int quickselect2(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (k <= j) {
            return quickselect2(nums, l, j, k);
        } else {
            return quickselect2(nums, j + 1, r, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        N1_findKthLargest findKthLargest = new N1_findKthLargest();
        int[] nums = new int[]{7, 6, 5, 4, 3, 2, 1};
        System.out.println(findKthLargest.findKthLargest(nums, 2));
    }
}
