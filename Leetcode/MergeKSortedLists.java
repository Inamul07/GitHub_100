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

    public ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        ListNode head = new ListNode(0), trav = head;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                trav.next = head1;
                head1 = head1.next;
            } else {
                trav.next = head2;
                head2 = head2.next;
            }
            trav = trav.next;
        }
        if(head1 != null) trav.next = head1;
        if(head2 != null) trav.next = head2;
        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for(ListNode node: lists) head = merge(head, node);
        return head;
    }
}
