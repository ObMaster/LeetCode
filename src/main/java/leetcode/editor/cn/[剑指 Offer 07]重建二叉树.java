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

import java.util.HashMap;
import java.util.Map;

//Java：重建二叉树
class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        // TO TEST

        int[] preorder = {3,9,5,20,15,22,19,7,30}, inorder = {5,9,3,22,15,19,20,7,30};

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

    ///**
    // * 方案一：
    // * @param preorder
    // * @param inorder
    // * @return
    // */
    //public TreeNode buildTree(int[] preorder, int[] inorder) {
    //    if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)   return null;
    //
    //    // 1、设置当前根节点
    //    int root = preorder[0];
    //    TreeNode tn = new TreeNode(root);
    //
    //    // 2、设置当前节点左子树
    //    int index = getIndex(inorder, root);
    //    // 2.1 获取左子树的前序遍历和中序遍历数组
    //    int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + index);
    //    int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
    //    tn.setLeft(buildTree(leftPreorder, leftInorder));
    //
    //    // 3、设置当前节点右子树
    //    int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
    //    int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
    //    tn.setRight(buildTree(rightPreorder, rightInorder));
    //    return tn;
    //}
    //
    ///**
    // * 从中序遍历数组中获取根节点的索引，也即左子树的长度
    // * @param a
    // * @param target
    // * @return
    // */
    //public int getIndex(int[] a, int target) {
    //    for (int i = 0; i < a.length; i++) {
    //        if (target == a[i])     return i;
    //    }
    //    return -1;
    //}

    /**
     * 方案二：优化
     *  1、getIndex方法用map集合来实现
     *  2、用参数来声明每个数组的范围，而不是生成新的数组
     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)   return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length- 1, 0);
        //return build(preorder, 0, preorder.length- 1, inorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param preorder  当前节点的前序遍历数组
     * @param pleft     当前节点的前序遍历数组的起始索引
     * @param pright    当前节点的前序遍历数组的终止索引
     * @param inorder   当前节点的中序遍历数组
     * @param ileft     当前节点的中序遍历数组的起始索引
     * @param iright    当前节点的中序遍历数组的终止
     * @return
     */
    private TreeNode build(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if (pleft > pright)     return null;
        // 1、设置当前根节点
        int root = preorder[pleft];
        TreeNode tn = new TreeNode(root);

        // 2、设置当前节点左子树
        int index = map.get(root);
        int len = index - ileft;
        // 2.1 获取左子树的前序遍历和中序遍历数组
        tn.setLeft(build(preorder, pleft + 1, pleft + len , inorder, ileft, index -1));

        // 3、设置当前节点右子树
        tn.setRight(build(preorder, pleft + len + 1, pright, inorder, index + 1, iright));

        return tn;
    }

    /**
     * 方案三：继续优化
     *
     *  方案二的递归方法一共有6个参数（数组 + 左右边界） * 2
     *  但是，如果去除掉第一行的return语句，我们实际用到的只有三个值：
     *      preorder + pleft :用来求root节点
     *      ileft ：用来求root节点左子树的长度
     *  也就是说剩下的三个参数：pright、inorder、iright没用，故我们可以将其优化调，
     *  但同时，我们需要一个终止条件，故pright和iright必须保留其中的一个，
     *  优化后的递归函数如下:
     *      TreeNode build(int[] preorder, int pleft, int pright, int ileft)
     *  或者
     *      TreeNode build(int[] preorder, int pright, int ileft, int ileft)
     *      此时，递归终止条件为 ileft > iright
     */

    public TreeNode build(int[] preorder, int pleft, int pright, int ileft) {
        if (pleft > pright)     return null;
        // 1、设置当前根节点
        int root = preorder[pleft];
        TreeNode tn = new TreeNode(root);

        // 2、设置当前节点左子树
        int index = map.get(root);
        int len = index - ileft;
        // 2.1 获取左子树的前序遍历和中序遍历数组
        tn.setLeft(build(preorder, pleft + 1, pleft + len , ileft));

        // 3、设置当前节点右子树
        tn.setRight(build(preorder, pleft + len + 1, pright, index + 1));

        return tn;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
