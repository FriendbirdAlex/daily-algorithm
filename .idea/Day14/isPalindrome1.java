/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 简单做法：转成 List 再判断
        List<Integer> list = new ArrayList<>();
        // 1. 复制到数组
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 2. 双指针向中间逼近
        int left = 0;
        int right = list.size() - 1;
        while(left < right) {
            if(!list.get(left).equals(list.get(right))) { // 注意 Integer 比较用 equals
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
