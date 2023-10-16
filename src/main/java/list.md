# ch1

### 回溯 backtrack

Permute 全排列

1. letterCombinations 电话号码的字母组合
2. 组合总和 List<List<Integer>> combinationSum(int[] candidates, int target)
3. 单词搜索 boolean exist(char[][] board, String word)

### bfs

minDepth 二叉树的最小深度  
OpenLock 打开转盘锁

### 双指针

HasCycle 环形链表（仅判断是否有环）【一遍过】 DetectCycle 环形链表二(找到开始入环的第一个节点)【一遍过】 GetKthFromEnd 链表中倒数第k个节点【一遍过】

1. moveZeroes 移动零
2. maxArea 盛最多水的容器

### 滑动窗口

checkInclusion 字符串的排列（s1的排列之一是s2的子串）  
findAnagrams 找到字符串中的所有字母异位词  
lengthOfLongestSubstring 无重复字符的最长子串  
minWindow 最小覆盖子串

# ch2 动态规划

1. lengthOfLIS 最长递增子序列
2. maxEnvelopes 俄罗斯套娃信封问题
3. maxSubArray 连续子数组的最大和【过】
4. xx
5. longestCommonSubsequence 最长公共子序列
6. minDistance 编辑距离
7. longestPalindromeSubseq 最长回文子序列
8. xx
9. minInsertions 让字符串成为回文串的最少插入次数
10. isMatch 正则表达式匹配
11. maxA 4键键盘显示最多A的个数
12. superEggDrop 鸡蛋掉落
13. xx
14. xx
15. maxCoins 戳气球
16. canPartition 分割等和子集
17. change 零钱兑换2（有几种可能，每一种面额无限）
18. rob 打家劫舍
19. rob 打家劫舍2（围成一圈）
20. rob 打家劫舍3（二叉树）

# ch3

1. LRUCache LRU缓存
2. LFUCache LFU缓存
3. insertIntoBST 二叉搜索树的插入操作
4. countNodes 完全二叉树的节点个数
5. Codec 二叉树的序列化和反序列化
6. lowestCommonAncestor 二叉树的最近公共祖先
7. nextGreaterElements 下一个更大元素（单调栈）dailyTemperatures 每日温度（单调栈）
8. maxSlidingWindow 单调队列解决滑动窗口问题
9. isPalindrome 判断链表是否为回文链表 【思路需要强化：找中点，然后reverse后半部分】
10. reverseList 反转链表（迭代和递归两种）【递归一开始没有想起来】
11. reverseKGroup K个一组反转链表【注意reverse前，先断开即将反转的链表】
12. N12_AllOne 全 O(1) 的数据结构【map+双向链表+node中维护同频次的setList】

## 链表

1. getIntersectionNode 相交链表(返回两个链表相交的起始节点)【没有思路：巧妙的while比较】
2. mergeTwoLists 合并两个有序链表 【一遍过】
3. addTwoNumbers 两数相加（逆序存储，返回和的链表）【思路简单，注意优化，一开始三个while循环可以优化为一个】
4. removeNthFromEnd 删除链表的倒数第 N 个结点 【一遍过】
5. swapPairs 两两交换链表中的节点 【一遍过】
6. sortList 排序链表【没有思路：归并排序，注意断开左右两侧再递归】
7. mergeKLists 合并 K 个升序链表【没有思路：L2的升级版，归并后两两进行排序】

# ch4

### 回溯 backtrack

1. subsets子集 ； permute全排列 ； combine组合
2. isValidSudoku 有效的数独 ； solveSudoku 解数独
3. isValid 有效括号 ； generateParenthesis 括号生成
4. slidingPuzzle 滑动谜题
5. TwoSum 两数之和-数据结构设计 ； twoSum 两数之和
6. threeSum 三数之和
7. xx
8. pancakeSort 煎饼排序翻转
9. maxSubArray 最大子数组和
10. NestedIterator 扁平化嵌套列表迭代器

# ch5

1. countPrimes 素数的数量
2. superPow 超级次方 （N12_addStrings 大数相加，相乘）
3. minEatingSpeed 爱吃香蕉的猩猩
4. shipWithinDays 船在D天内送达包裹的能力
5. removeDuplicates 删除有序数组中的重复项； deleteDuplicates删除排序链表中的重复元素
6. xx
7. canJump 跳跃游戏（能否到达最后一个下标）；jump 跳跃游戏2（最小跳跃次数）
8. eraseOverlapIntervals 无重叠区间（需要移除区间的最小数量）；findMinArrowShots 用最少数量的箭引爆气球
9. trap 接雨水
10. ExamRoom 考场就座

### hash
11. longestConsecutive 最长连续序列（未排序数组）
12. groupAnagrams 字母异位词分组（[["bat"],["nat","tan"],["ate","eat","tea"]]）

# hot100
## Sub1_Hash
1. twoSum(int[] nums, int target) 两数之和【过】
2. groupAnagrams(String[] strs) 字母异位词分组【再看】
3. longestConsecutive(int[] nums) 最长连续序列【再看】

## Sub2_双指针
1. moveZeroes(int[] nums) 移动零【过】
2. maxArea(int[] height) 盛水最多的容器【再看】
3. threeSum(int[] nums) 三数之和【再写】
4. trap(int[] height) 接雨水【思路简单，再写】

## Sub3_滑动窗口
1. lengthOfLongestSubstring(String s) 无重复字符的最长子串【过】
2. findAnagrams(String s, String p) 找到字符串中所有字母异位词【思路简单，再写】

## Sub4_subString
1. subarraySum(int[] nums, int k) 和为K的子数组【思路很难想，前缀和】
2. maxSlidingWindow(int[] nums, int k) 滑动窗口最大值【再写，维护降序queue】
3. minWindow(String s, String t) 最小覆盖子串【再写】

## Sub5_普通数组
1. maxSubArray(int[] nums) 最大子数组和【过】
2. int[][] merge(int[][] intervals) 合并区间【有思路，再写】
3. rotate(int[] nums, int k) 轮转数组【反转，一开始没有思路】
4. productExceptSelf(int[] nums) 除自身以外数组的乘积【左右边界数组，再写】
5. firstMissingPositive(int[] nums) 缺失的第一个正数【交换，再写】

## Sub6_矩阵
1. setZeroes(int[][] matrix) 矩阵置零【再写】
2. spiralOrder(int[][] matrix) 螺旋矩阵【再写】
3. xx
4. searchMatrix(int[][] matrix, int target) 搜索二维矩阵2【Z字搜索，再写】

## Sub7_链表

## N8_二叉树
1. inorderTraversal(TreeNode root) 二叉树的中序遍历【递归简单；迭代的需要再看一下】
2. maxDepth(TreeNode root) 二叉树的最大深度【过】
3. invertTree(TreeNode root) 翻转二叉树【过】
4. isSymmetric(TreeNode root) 对称二叉树【过】
5. diameterOfBinaryTree(TreeNode root) 二叉树的直径【过】
6. levelOrder(TreeNode root) 二叉树的层序遍历【过】 
7. sortedArrayToBST(int[] nums) 将有序数组转换为二叉搜索树【过】
8. isValidBST(TreeNode root) 验证二叉搜索树【过】
9. kthSmallest(TreeNode root, int k) 二叉搜索树中第K小的元素【利用迭代中序遍历】
10. rightSideView(TreeNode root) 二叉树的右视图【过】
11. flatten(TreeNode root) 二叉树展开为链表【有点磕磕绊绊】
12. buildTree(int[] preorder, int[] inorder)  从前序与中序遍历序列构造二叉树【再写】
13. pathSum(TreeNode root, int targetSum) 路径总和 III【前缀和，挺难想的】
14. xx
15. maxPathSum(TreeNode root) 二叉树中的最大路径和【前缀和，有点难】


## Sub9_图论

## Sub10_回溯
1. xx
2. xx
3. letterCombinations(String digits) 电话号码的字母组合【过】
4. combinationSum(int[] candidates, int target) 组合总和
5. xx
6. exist(char[][] board, String word) 单词搜索


## N11_二分查找
1. searchInsert(int[] nums, int target) 搜索插入位置【过】
2. searchMatrix(int[][] matrix, int target) 搜索二维矩阵【过】
3. searchRange(int[] nums, int target) 在排序数组中查找元素的第一个和最后一个位置【二分找左右边界，再写】
4. rotateSearch(int[] nums, int target) 搜索旋转排序数组【再写】
5. findMin(int[] nums) 寻找旋转排序数组中的最小值【再写】
6. findMedianSortedArrays(int[] nums1, int[] nums2) 寻找两个正序数组的中位数【未写】

## N12_栈
1. bracketsIsValid 有效的括号【过】
2. minStack 最小栈【再刷；一开始没想起来，但思路简单】
3. decodeString(String s) 字符串解码【再刷；递归】
4. dailyTemperatures(int[] temperatures) 每日温度【再刷；小顶栈，从右开始】
5. largestRectangleArea(int[] heights) 柱状图中最大的矩形【再刷；大顶栈】

## N13_堆
1. findKthLargest(int[] nums, int k) 数组中的第k个最大元素【再刷；快排思想改进，quickSelect】
2. topKFrequent(int[] nums, int k) 前k个高频元素【再刷；map统计频次+优先级队列】
3. MedianFinder 数据流的中位数【再刷；两个优先级队列，分别存放一般的值，left是大顶堆，right是小顶堆】

## N14_贪心
1. maxProfit(int[] prices) 买卖股票的最佳时机【过】
2. boolean canJump(int[] nums) 跳跃游戏【过，维护farthest】
3. int jump(int[] nums) 跳跃游戏2【过，按层遍历】
4. partitionLabels(String s) 划分字母区间【维护一个字母与最后位置的map，后续类似于跳跃2，看有多少层】

## N15_动规
1. int climbStairs(int n) 爬楼梯【过】
2. List<List<Integer>> generate(int numRows) 杨辉三角【过】
3. int rob(int[] nums) 打家劫舍 【过】
4. int numSquares(int n) 完全平方数 【需再看，思路简单】
5. int coinChange(int[] coins, int amount) 零钱兑换 【硬币无限，经典再看】
6. boolean wordBreak(String s, List<String> wordDict) 单词拆分【再看】
7. int lengthOfLIS(int[] nums) 最长递增子序列 【经典再看】
8. int maxProduct(int[] nums) 乘积最大子数组 【再看：思路简单，注意负数的处理】
9. boolean canPartition(int[] nums) 分割等和子集 【需再看】
10. int longestValidParentheses(String s) 最长有效括号 【再看：思路简单，注意数组越界】

## Sub16_多维动归
1. uniquePaths(int m, int n) 不同路径【过】
2. minPathSum(int[][] grid) 最小路径和【过】
3. longestPalindrome(String s) 最长回文子串【经典再写】
4. longestCommonSubsequence(String text1, String text2) 最长公共子序列【过】
5. minDistance(String word1, String word2) 编辑距离【过】

## Sub17_技巧
1. singleNumber(int[] nums) 只出现一次的数字【过】
2. majorityElement2(int[] nums) 多数元素，众数【思路有趣，再写】
3. sortColors(int[] nums) 颜色分类【再写】
4. nextPermutation(int[] nums) 下一个排列【字典序，有实际用处，c++STL收录】
5. findDuplicate(int[] nums) 寻找重复数【有趣的思路，判断链表有环的思路】