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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. 使用快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时 slow 指向链表的中点（如果是偶数长度，指向下中点）

        // 2. 反转后半部分链表
        // 这里的 reverseList 是一个辅助函数
        ListNode secondHalfStart = reverseList(slow);

        // 3. 比较前半部分和反转后的后半部分
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;

        boolean isPalindrome = true;

        // 只需要判断 p2 是否走完即可
        // 因为对于奇数长度，p2 会比 p1 短一个节点（中点），但不影响判断
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. (可选) 恢复链表，养成好习惯
        // reverseList(secondHalfStart);

        return isPalindrome;
    }

    // 辅助函数：反转链表（LeetCode 206 原题）
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}