package leetcode.editor.cn;

//给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。 
//
// 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。 
//
// 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。 
//
// 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = 
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]], 
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 2 
//行 4 -> 5 
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
// 
//
// 示例 2： 
//
// 
//输入：mat = 
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]], 
//k = 2
//输出：[0,2]
//解释： 
//每行中的军人数目：
//行 0 -> 1 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 1 
//从最弱到最强对这些行排序后得到 [0,2,3,1]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] 不是 0 就是 1 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 87 👎 0

import java.util.*;

//Java：矩阵中战斗力最弱的 K 行
class TheKWeakestRowsInAMatrix{
    public static void main(String[] args) {
        Solution solution = new TheKWeakestRowsInAMatrix().new Solution();
        int[][] a = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[] ints = solution.kWeakestRows(a, 3);
        for (int x : ints)
            System.out.print(x + " ");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        /**
         * 遍历整行求军人数，然后排序
         */
        //int m = mat.length;
        //int[] tmp = new int[m];
        //int[] rs = new int[k];
        //for (int i = 0; i < m; i++) {
        //    tmp[i] = 0;
        //    for (int x : mat[i]) {
        //        if (x == 0) break;
        //        tmp[i] += x;
        //    }
        //    tmp[i] = tmp[i] * 10000 + i;
        //}
        //Arrays.sort(tmp);
        //for (int i = 0; i < k; i++) {
        //    rs[i] = tmp[i] % 10000;
        //}
        //return rs;

        /**
         * 二分遍历
         */
        int m = mat.length;
        int n = mat[0].length;
        int[] tmp = new int[m];
        int[] rs = new int[k];
        int left, right, mid;
        for (int i = 0; i < m; i++) {
            tmp[i] = 0;
            left = 0;
            right = n - 1;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (mat[i][mid] == 1)   left = mid + 1;
                else right = mid;
            }
            tmp[i] = mat[i][left] == 1 ? (left + 1) * 10000 + i : left * 10000 + i;
        }
        Arrays.sort(tmp);
        for (int i = 0; i < k; i++) {
            rs[i] = tmp[i] % 10000;
        }
        return rs;



        //Map<Integer, Integer> map = new HashMap<>();
        //for (int i = 0; i < mat.length; ++i) {
        //    int cnt = 0;
        //    for (int anInt : mat[i]) {
        //        if (anInt == 1) cnt++;
        //    }
        //    map.put(i, cnt);
        //}
        //System.out.println(map);
        //List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        ////Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        //Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        //System.out.println(list);
        //int x = 0;
        //int[] rs = new int[k];
        //while (x < k) {
        //    rs[x] = list.get(x).getKey();
        //    x++;
        //}
        //return rs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
