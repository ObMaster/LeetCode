package leetcode.editor.cn;

//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 349 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：二叉树中所有距离为 K 的结点
class AllNodesDistanceKInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
        TreeNode one = new TreeNode(2);
        one.left = new TreeNode(7);
        one.right = new TreeNode(4);
        TreeNode two = new TreeNode(5);
        two.left = new TreeNode(6);
        two.right = one;
        TreeNode three = new TreeNode(1);
        three.left = new TreeNode(0);
        three.right = new TreeNode(8);
        TreeNode root = new TreeNode(3);
        root.left = two;
        root.right = three;
        List<Integer> list = solution.distanceK(root, new TreeNode(5), 2);
        list.forEach(System.out::println);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, TreeNode> map = new HashMap<>();
    List list = new ArrayList();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        //target = map.get(target.val);
        findAns(target, null, 0, k);
        return list;
    }

    public void findParent(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            findParent(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            findParent(root.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null)   return;
        if (depth == k) {
            list.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        if (map.get(node.val) != from) {
            findAns(map.get(node.val), node, depth + 1, k);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}
}
