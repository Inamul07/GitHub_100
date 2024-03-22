// url: https://leetcode.com/problems/palindrome-linked-list/

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
        if(head.next == null) return true;

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

        // Check Equality
        while(trav1 != null && trav2 != null) {
            if(trav1.val != trav2.val) return false;
            trav1 = trav1.next;
            trav2 = trav2.next;
        }

        if((trav1 != null && trav1.next != null) || (trav2 != null && trav2.next != null)) return false;

        return true;
    }
}
