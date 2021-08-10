package leetcode.editor.cn;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 数组 回溯 
// 👍 965 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：N 皇后
class NQueens{
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(4);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private char[][] k;
    private int n;
    private List<List<String>> lists;

    public List<List<String>> solveNQueens(int n) {
        lists = new ArrayList<>();
        k = new char[n][n];
        this.n = n;
        for (char[] chars : k) {
            Arrays.fill(chars, '.');
        }
        backTracking(0);
        return lists;
    }

    private void backTracking(int r) {
        // 每一行一个皇后，用行来做回溯，回溯的深度（递归的深度）就是行大小
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : k) {
                list.add(new String(chars));
            }
            lists.add(list);
        } else {
            // 每一行的皇后位置的回溯
            for (int i = 0; i < n; i++) {
                if (!havaHH(r, i)) {
                    // 符合条件，设为皇后节点
                    k[r][i] = 'Q';
                    // 继续往下遍历
                    backTracking(r + 1);
                    // 回溯到当前节点，回复当前节点的值
                    k[r][i] = '.';
                }
            }
        }
    }

    private boolean havaHH(int x, int y) {
        int length = k.length;
        // 判断同一行是否有皇后
        for (int i : k[x]) {
            if (i == 'Q') return true;
        }

        // 判断同一列是否有皇后
        for (int i = 0; i < length; i++) {
            if (k[i][y] == 'Q')   return true;
        }

        int[] ax = {-1, -1, 1, 1};
        int[] ay = {-1, 1, -1, 1};

        // 判断斜线上是否有皇后
        for (int l = 0; l < 4; l++) {
            int ix = x + ax[l], iy = y + ay[l];
            while (ix >= 0 && ix < length && iy >= 0 && iy < length) {
                if (k[ix][iy] == 'Q')   return true;
                ix += ax[l];
                iy += ay[l];
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
