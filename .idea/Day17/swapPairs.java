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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode temp=dummy;
        while(temp.next!=null&&temp.next.next!=null){
            ListNode L1=temp.next;
            ListNode L2=temp.next.next;
            L1.next=L2.next;
            L2.next=L1;
            temp.next=L2;
            temp=L1;
        } return dummy.next;
    }
}