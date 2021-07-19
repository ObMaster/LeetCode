package leetcode.editor.cn;

//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 
// 👍 474 👎 0

//Java：数组中重复的数字
class ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.findRepeatNumber(a));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findRepeatNumber(int[] nums) {
            /**
             * 解法一：利用Set集合特性
             *  时间复杂度：O(N)，遍历数组使用O(N)，HashSet添加和查找均为O(1)
             *  空间复杂度：O(N)，HashSet占用O(N)大小的额外空间
             */

            //Set<Integer> set = new HashSet<>();
            //for (int num : nums) {
            //    if (!set.add(num)) {
            //        return num;
            //    }
            //}

            /**
             * 解法二：利用数值元素的索引和值的一一对应关系
             * 时间复杂度：O(N)，遍历数组使用O(N)，HashSet添加和查找均为O(1)
             * 空间复杂度：O(1)，
             */
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == i) {
                    continue;
                }
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }


            return 0;
        }
//leetcode submit region end(Prohibit modification and deletion)
    }
}
