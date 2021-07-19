package leetcode.editor.cn;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 164 👎 0

//Java：斐波那契数列
class FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1000000007 * 2);
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        System.out.println(solution.fib(3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        int a = 0, b = 1, c = 0;
        //if (n < 2) {
        //    return n;
        //}

        // 对于f(n),需要循环n - 1次，故i <= n 或 i < n + 1
        //f(n) = f(n - 1) + f(n - 2)
        //   c =     b    +    a
        //for (int i = 2; i <= n; i++) {
        //    c = (a + b) % 1000000007;
        //    a = b;
        //    b = c;
        //}
        //return c;

        // 对于f(n),需要循环n次，从0开始，故 i < n
        // f(n + 2) = f(n + 1) + f(n)
        //        c =     b    +  a
        for (int i = 0; i < n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return a;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
