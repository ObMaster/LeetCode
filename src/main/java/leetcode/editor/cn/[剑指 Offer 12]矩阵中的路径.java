package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 373 👎 0

//Java：矩阵中的路径
class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        char a1 = '\0';
        char a2 = '\u0000';
        System.out.println(a1 == a2);
        System.out.println(a1 == ' ');
        System.out.println('\0');
        System.out.println(' ');
        System.out.println('\u0000');
        System.out.println('\u0020');
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        System.out.println(solution.exist(board, word));

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m, n;
    boolean[][] flag;
    String word;
    int len;
    public boolean exist(char[][] board, String word) {
        if (board == null)  return false;
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        flag = new boolean[m][n];
        this.word = word;
        len = word.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 通过数组标记状态
     * @param board
     * @param i
     * @param j
     * @param w
     * @return
     */
    private boolean dg(char[][] board, int i, int j, int w) {
        if (w >= len)   return true;
        if (i < 0 || i >= m || j < 0 || j >= n)   return false;
        boolean hasPath = false;
        if (board[i][j] == word.charAt(w) && !flag[i][j]) {
            flag[i][j] = true;

            hasPath = dg(board, i - 1, j, w + 1) ||     // 上
                      dg(board, i, j - 1, w + 1) ||     // 左
                      dg(board, i + 1, j, w + 1) ||     // 下
                      dg(board, i, j + 1, w + 1);       // 右
            if (!hasPath) flag[i][j] = false;
        }
        return hasPath;
    }

    /**
     * 通过将当前已匹配的字符设置为空字符''来实现状态
     */
    private boolean dfs(char[][] board, int i, int j, int w) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(w))   return false;
        if (w == len)   return true;
        boolean hasPath;
        board[i][j] = ' ';
        hasPath = dg(board, i - 1, j, w + 1) ||     // 上
                dg(board, i, j - 1, w + 1) ||     // 左
                dg(board, i + 1, j, w + 1) ||     // 下
                dg(board, i, j + 1, w + 1);       // 右
        board[i][j] = word.charAt(w);
        return hasPath;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
