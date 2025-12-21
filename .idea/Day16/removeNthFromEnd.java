class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first=head;
        ListNode sec=dummy;

        for(int i=0;i<n;i++){
            first=first.next;
        }
        while(first!=null){
            first=first.next;
            sec=sec.next;
        }
        sec.next=sec.next.next;
        return dummy.next;}}