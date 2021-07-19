package leetcode.editor.cn.node;

import lombok.Data;

/**
 * @author OMaster
 * @date 2021/7/15
 */
@Data
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
}
