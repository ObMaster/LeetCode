package leetcode.editor.cn.node;

import lombok.Data;

/**
 * @author OMaster
 * @date 2021/7/15
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}
