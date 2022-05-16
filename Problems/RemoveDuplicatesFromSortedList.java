// url: leetcode.com/problems/remove-duplicates-from-sorted-list/

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode trav = head;
        while(trav != null) {
            while(trav.next != null && trav.val == trav.next.val)
                trav.next = trav.next.next;
            trav = trav.next;
        }
        return head;
    }
}
