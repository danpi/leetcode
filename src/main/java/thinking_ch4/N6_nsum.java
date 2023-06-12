package thinking_ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import sort.Sorts;

public class N6_nsum {
    //有多种可能性，返回对应的元素对，不能重复
    //O(n*logn)
    public List<List<Integer>> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int indexL = 0, indexR = nums.length - 1;
        while (indexL < indexR) {
            int left = nums[indexL];
            int right = nums[indexR];
            int sum = left + right;
            if (sum == target) {
                res.add(Arrays.asList(left, right));
                //跳过重复的数
                while (indexL < indexR && nums[indexL] == left) {
                    indexL++;
                }
                while (indexL < indexR && nums[indexR] == right) {
                    indexR--;
                }
            } else if (sum < target) {
                while (indexL < indexR && nums[indexL] == left) {
                    indexL++;
                }
            } else if (sum > target) {
                while (indexL < indexR && nums[indexR] == right) {
                    indexR--;
                }
            }
        }
        return res;
    }

    //https://leetcode.cn/problems/3sum/
    //两数之和的基础上进行改造
    //O(nlogn+n*n)=O(n*n)
    public List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, -nums[i]);
            for (List<Integer> tuple : tuples) {
                List<Integer> result = new LinkedList<>(tuple);
                result.add(nums[i]);
                res.add(result);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int start, long target) {
        List<List<Integer>> res = new LinkedList<>();
        int indexL = start, indexR = nums.length - 1;
        while (indexL < indexR) {
            int left = nums[indexL];
            int right = nums[indexR];
            int sum = left + right;
            if (sum == target) {
                res.add(Arrays.asList(left, right));
                //跳过重复的数
                while (indexL < indexR && nums[indexL] == left) {
                    indexL++;
                }
                while (indexL < indexR && nums[indexR] == right) {
                    indexR--;
                }
            } else if (sum < target) {
                while (indexL < indexR && nums[indexL] == left) {
                    indexL++;
                }
            } else if (sum > target) {
                while (indexL < indexR && nums[indexR] == right) {
                    indexR--;
                }
            }
        }
        return res;
    }

    //https://leetcode.cn/problems/4sum/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = threeSumTarget(nums, i + 1, (long) target - (long) nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> threeSumTarget(int[] nums, int start, long target) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                List<Integer> result = new LinkedList<>(tuple);
                result.add(nums[i]);
                res.add(result);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public List<List<Integer>> nSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 3, 0, target);
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if (n < 2 || sz < 2) {
            return res;
        }
        //2sum
        if (n == 2) {
            int indexL = start, indexR = sz - 1;
            while (indexL < indexR) {
                int left = nums[indexL], right = nums[indexR];
                int sum = left + right;
                if (sum == target) {
                    List<Integer> suc = new LinkedList<>();
                    suc.add(left);
                    suc.add(right);
                    res.add(suc);
                    while (indexL < indexR && nums[indexL] == left) {
                        indexL++;
                    }
                    while ((indexL < indexR && nums[indexR] == right)) {
                        indexR--;
                    }
                }
                if (sum < target) {
                    while (indexL < indexR && nums[indexL] == left) {
                        indexL++;
                    }
                }
                if (sum > target) {
                    while (indexL < indexR && nums[indexR] == right) {
                        indexR--;
                    }
                }
            }
        } else {
            for (int i = start; i < sz; i++) {
                List<List<Integer>> subs = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> sub : subs) {
                    sub.add(nums[i]);
                    res.add(sub);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
