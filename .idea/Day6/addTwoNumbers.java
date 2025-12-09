/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. 创建虚拟头节点，作为结果链表的占位符
        ListNode dummy = new ListNode(-1);
        // cur 指针用来在结果链表上移动
        ListNode cur = dummy;

        // 2. 定义进位变量，初始为 0
        int carry = 0;

        // 3. 循环条件：只要 l1 没走完，或者 l2 没走完，或者还有进位没处理
        // "|| carry != 0" 这个条件非常关键，处理类似 5+5=10 的情况
        while (l1 != null || l2 != null || carry != 0) {

            // 获取当前位的值。如果节点为空，就用 0 代替
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // 计算当前位的总和 (两个数 + 之前的进位)
            int sum = x + y + carry;

            // 更新进位 (比如 sum=15, carry=1)
            carry = sum / 10;

            // 创建新节点存当前位的数字 (比如 sum=15, 存 5)
            cur.next = new ListNode(sum % 10);

            // 移动结果链表的指针
            cur = cur.next;

            // 移动 l1 和 l2 的指针 (如果它们不是 null 的话)
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 4. 返回真正的头节点
        return dummy.next;
    }
}