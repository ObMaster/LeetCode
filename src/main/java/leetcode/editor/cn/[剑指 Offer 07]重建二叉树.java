package leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 504 👎 0


import leetcode.editor.cn.node.TreeNode;

import java.util.Arrays;

//Java：重建二叉树
class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        // TO TEST

        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};

        System.out.println(solution.buildTree(preorder, inorder));
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

    /**
     * 方案一：
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)   return null;

        // 1、设置当前根节点
        int root = preorder[0];
        TreeNode tn = new TreeNode(root);

        // 2、设置当前节点左子树
        int index = getIndex(inorder, root);
        // 2.1 获取左子树的前序遍历和中序遍历数组
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + index);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        tn.setLeft(buildTree(leftPreorder, leftInorder));

        // 3、设置当前节点右子树
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        tn.setRight(buildTree(rightPreorder, rightInorder));
        return tn;
    }

    public int getIndex(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (target == a[i])     return i;
        }
        return -1;
    }

    /**
     * 方案二：
     */

}
//leetcode submit region end(Prohibit modification and deletion)

}
