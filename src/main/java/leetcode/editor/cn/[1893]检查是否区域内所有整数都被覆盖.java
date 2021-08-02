package leetcode.editor.cn;

//给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 star
//ti 到 endi 的 闭区间 。 
//
// 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。 
//
// 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
//输出：true
//解释：2 到 5 的每个整数都被覆盖了：
//- 2 被第一个区间覆盖。
//- 3 和 4 被第二个区间覆盖。
//- 5 被第三个区间覆盖。
// 
//
// 示例 2： 
//
// 
//输入：ranges = [[1,10],[10,20]], left = 21, right = 21
//输出：false
//解释：21 没有被任何一个区间覆盖。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ranges.length <= 50 
// 1 <= starti <= endi <= 50 
// 1 <= left <= right <= 50 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 90 👎 0

//Java：检查是否区域内所有整数都被覆盖
class CheckIfAllTheIntegersInARangeAreCovered{
    public static void main(String[] args) {
        Solution solution = new CheckIfAllTheIntegersInARangeAreCovered().new Solution();
        // TO TEST
        int[][] a = {{1, 10}, {10, 20}};
        boolean covered = solution.isCovered(a, 21, 21);
        System.out.println(covered);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {

            /**
             * 方法一：暴力遍历法
             */
            //while (left <= right) {
            //    boolean flag = false;
            //    for (int[] range : ranges) {
            //        if (left >= range[0] && left <= range[1]) {
            //            flag = true;
            //            break;
            //        }
            //    }
            //    if (!flag)  return false;
            //    left++;
            //}
            //return true;

            /**
             * 解法二：排序法
             */
            //Arrays.sort(ranges, (a1, a2) -> a1[0] - a2[0]);
            //for (int[] range : ranges) {
            //    // left 位于当前区间，更新left的值
            //    if (left >= range[0] && left <= range[1]) {
            //        left = range[1] + 1;
            //    }
            //}
            //return left > right;

            /**
             * 解法三：差分数组
             */
            int[] dif = new int[52];
            // 1. 构造差分数组
            for (int[] range : ranges) {
                dif[range[0]]++;
                dif[range[1] + 1]--;
            }
            // 2、求前缀和
            int[] sum = new int[52];
            for (int i = 1; i < 52; i++) {
                sum[i] = sum[i - 1] + dif[i];
            }
            //3、遍历判断
            while (left <= right) {
                if (sum[left++] <= 0) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
