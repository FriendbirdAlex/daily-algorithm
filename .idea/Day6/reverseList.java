class Solution {
    public ListNode reverseList(ListNode head) {
        // 1. 初始化两个指针
        ListNode prev = null; // 新链表的头（刚开始是空的）
        ListNode curr = head; // 遍历用的指针

        // 2. 只要 curr 还没走到头（null），就继续反转
        while (curr != null) {
            // Step 1: 记 (留后路)
            // 必须先存下个节点，因为下一行代码会断开链接
            ListNode next = curr.next;

            // Step 2: 改 (反转)
            // 让当前节点指回前一个节点
            curr.next = prev;

            // Step 3: 移 (推进 prev)
            // prev 变成了当前节点，为下一次循环做准备
            prev = curr;

            // Step 4: 走 (推进 curr)
            // curr 走到刚才记下的 next 位置
            curr = next;
        }

        // 3. 返回新头
        // 循环结束时，curr 变成了 null，prev 刚好停在最后一个非空节点上（也就是新的头）
        return prev;
    }
}