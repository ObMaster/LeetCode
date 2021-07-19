package leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 164 👎 0

import leetcode.editor.cn.node.ListNode;

//Java：从尾到头打印链表
class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        System.out.println(solution.reversePrint(l1));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

class Solution {
    public int[] reversePrint(ListNode head) {
        int[] a = new int[10001];
        int x = 0;

        while (head != null) {
            a[x++] = head.getVal();
            head = head.getNext();
        }

        int[] b = new int[x];

        for (int i = 0, j = x - 1; i < x; i++, j--) {
            //int temp = a[i];
            //a[i] = a[j];
            //a[j] = temp;
            b[i] = a[j];
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
