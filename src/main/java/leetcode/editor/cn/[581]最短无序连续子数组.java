package leetcode.editor.cn;

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 647 👎 0

//Java：最短无序连续子数组
class ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        int[] a = {2,6,4,8,10,9,15};
        System.out.println(solution.findUnsortedSubarray(a));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //if (isSorted(nums)) return 0;
        //int length = nums.length;
        //int[] a = new int[length];
        //int x = 0;
        //for (int num : nums) {
        //    a[x++] = num;
        //}
        //Arrays.sort(a);
        //int i = 0, j = length - 1;
        //while (a[i] == nums[i]) {
        //   i++;
        //}
        //while (a[j] == nums[j]) {
        //    j--;
        //}
        //return j - i + 1;

        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

        public boolean isSorted(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
            return true;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
