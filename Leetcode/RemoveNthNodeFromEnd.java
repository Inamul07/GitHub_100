// url: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode trav1 = head, trav2 = head, prev = null;
        for(int i = 0; i < n; i++) trav2 = trav2.next;
        if(trav2 == null) return head.next;
        while(trav2.next != null) {
            trav1 = trav1.next;
            trav2 = trav2.next;
        }
        trav1.next = trav1.next.next;
        return head;
    }
}
