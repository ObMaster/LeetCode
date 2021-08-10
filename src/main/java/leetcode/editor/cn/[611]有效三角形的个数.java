package leetcode.editor.cn;

//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 242 👎 0

import java.util.Arrays;

//Java：有效三角形的个数
class ValidTriangleNumber{
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
        int [] a = {2,2,3,4};
        System.out.println(solution.triangleNumber(a));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int cnt = 0;
        /**
         * 方法一：暴力的优化，对于第三条边，通过二分来查找，而不是暴力查找
         */
        //for (int i = 0; i < length; i++) {
        //    for (int j = i + 1; j < length; j++) {
        //        int left = j + 1;
        //        int right = length - 1;
        //        int k = j;
        //        while (left <= right) {
        //            int mid = left + (right - left) / 2;
        //            if (nums[mid] < nums[i] + nums[j]) {
        //                left = mid + 1;
        //                k = mid;
        //            } else right = mid - 1;
        //        }
        //        cnt += k - j;
        //    }
        //}

        /**
         * 方法二：因为要排除调k = j的情况，故这里的k的初值为i，而不是i + 1
         */
        //for (int i = 0; i < length; i++) {
        //    int k = i;
        //    for (int j = i + 1; j < length; j++) {
        //        while (k + 1 < length && nums[k + 1] < nums[i] + nums[j]) {
        //            k++;
        //        }
        //        cnt += Math.max(k - j, 0);
        //    }
        //}

        /**
         * 方法三：倒叙遍历，先确定最长边，统计符合条件的另外两条边
         */
        for (int i = length - 1; i >= 0; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    cnt += right - left;
                    right--;
                } else left++;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
