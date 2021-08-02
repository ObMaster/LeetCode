package leetcode.editor.cn;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ —— 动态规划
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 1733 👎 0

//Java：最长递增子序列
class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        // TO TEST
        int[] a = {0,1,0,3,2,3};
        System.out.println(solution.lengthOfLIS(a));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {

        /**
         * 方法一：动态规划
         *  时间复杂度：O(n2)
         *  空间复杂度：O(n)
         */
        //int[] dp = new int[nums.length];
        //Arrays.fill(dp, 1);
        //int max = dp[0];
        //for (int i = 1; i < nums.length; i++) {
        //    for (int j = i - 1; j >= 0; j--) {
        //        if (nums[i] > nums[j]) {
        //            dp[i] = Math.max(dp[i], dp[j] + 1);
        //        }
        //    }
        //    max = Math.max(dp[i], max);
        //}
        //return max;

        /**
         * 优化
         */
        //int[] dp = new int[nums.length];
        //int max = 1;
        //for (int i = 0; i < nums.length; i++) {
        //    dp[i] = 1;
        //    for (int j = 0; j < i; j++) {
        //        if (nums[i] > nums[j]) {
        //            dp[i] = Math.max(dp[i], dp[j] + 1);
        //        }
        //    }
        //    max = Math.max(dp[i], max);
        //}
        //return max;

        /**
         * 二分法：
         */
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
