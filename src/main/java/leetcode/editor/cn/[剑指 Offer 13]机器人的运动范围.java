package leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 329 👎 0

//Java：机器人的运动范围
class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int sum = 0;
    boolean[][] a;
    int m, n;

    public int movingCount(int m, int n, int k) {
        a = new boolean[m][n];
        this.m = m;
        this.n = n;
        add(0, 0, k);
        return sum;
    }

    private void add(int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] ||addNum(i) + addNum(j) > k)
            return;
        sum++;
        a[i][j] = true;
        add(i + 1, j, k);
        add(i, j + 1, k);
    }

    private int addNum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
