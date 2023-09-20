package exercise;

import common.ListNode;
import common.TreeNode;
import framework_ch1.slidingWindow.CheckInclusion;

import java.lang.reflect.Array;
import java.time.chrono.MinguoDate;
import java.util.*;

public class Solution {
    int countPrime(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(n)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }

    int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            while (window.get(cur) > 1) {
                char deleteCh = s.charAt(left);
                left++;
                window.put(deleteCh, window.get(deleteCh) - 1);
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String oddStr = validPalindrome(s, i, i);
            String evenStr = validPalindrome(s, i, i + 1);
            res = res.length() < oddStr.length() ? oddStr : res;
            res = res.length() < evenStr.length() ? evenStr : res;
        }
        return res;
    }

    String validPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return s.substring(left, right + 1);
    }

    public int reverse(int x) {
        int reverseNumber = 0;
        while (x != 0) {
            int last = x % 10;
            x = x / 10;
            if (reverseNumber > Integer.MAX_VALUE / 10 || (reverseNumber == Integer.MAX_VALUE / 10 && last > 7)) {
                return 0;
            }
            if (reverseNumber < Integer.MIN_VALUE / 10 || (reverseNumber == Integer.MIN_VALUE / 10 && last < -8)) {
                return 0;
            }
            reverseNumber = reverseNumber * 10 + last;
        }
        return reverseNumber;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 != null) {
            pre.next = list1;
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return dummy.next;
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    private Integer m;
    private Integer n;
    private String s;

    public List<List<String>> partition(String s) {
        LinkedList<String> path = new LinkedList<>();
        this.s = s;
        dfs(s, 1, 0, path);
        return null;
    }

    void dfs(String s, int index, int start, LinkedList<String> path) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        //not choose next;
        if (index < s.length() - 1) {
            dfs(s, index + 1, start, path);
        }

        if (isPalindrome(start,index)){
            path.addLast(s.substring(start,index+1));
            dfs(s,index+1,index+1,path);
            path.removeLast();
        }

    }

    boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 6, 7};
        //System.out.println(solution.exist(3));
    }
}
