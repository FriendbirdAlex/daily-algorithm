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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode end=dummy;
        while(end.next!=null){
            for(int i =0;i<k&&end!=null;i++){
                end=end.next;
            }
            if(end==null){
                break;
            }
            ListNode start=pre.next;
            ListNode nextGroup=end.next;
            end.next=null;
            pre.next=reverse(start);
            start.next=nextGroup;
            pre=start;
            end=pre;
        }return dummy.next;
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}