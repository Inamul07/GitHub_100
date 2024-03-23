// url: https://leetcode.com/problems/reorder-list/

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
    public void reorderList(ListNode head) {
        // Get Middle of the Linked List
        ListNode trav1 = head, trav2 = head, prev = null;
        while(trav2 != null) {
            prev = trav1;
            trav1 = trav1.next;
            trav2 = trav2.next;
            if(trav2 != null) trav2 = trav2.next;
        }
        prev.next = null;
        trav2 = trav1;
        trav1 = head;

        // Reverse Second half of the list
        prev = null;
        while(trav2 != null) {
            ListNode next = trav2.next;
            trav2.next = prev;
            prev = trav2;
            trav2 = next;
        }
        trav2 = prev;

        while(trav1 != null && trav2 != null) {
            ListNode next1 = trav1.next, next2 = trav2.next;
            trav1.next = trav2;
            trav2.next = next1;
            trav1 = next1;
            trav2 = next2;
        }
    }
}
