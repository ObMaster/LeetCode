package leetcode.editor.cn;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 二分查找 分治 矩阵 
// 👍 383 👎 0

//Java：二维数组中的查找
class ErWeiShuZuZhongDeChaZhaoLcof{
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        int[][] a = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int[][] b = {};
        System.out.println(solution.findNumberIn2DArray(null, 25));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        //for (int i = 0; i < m; i++) {
        //    for (int j = n - 1; j >= 0; j--) {
        //        int cur = matrix[i][j];
        //        if (target == cur){
        //            return true;
        //        }
        //        if (target < cur) {
        //            continue;
        //        }
        //        if(target > cur) {
        //            break;
        //        }
        //    }
        //}

        /**
         * 优化
         */
        int row = 0, columns = n - 1;
        while (row < m && columns >= 0) {
            int num = matrix[row][columns];
            if (num < target) {
                row++;
            } else if (num > target) {
                columns--;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
