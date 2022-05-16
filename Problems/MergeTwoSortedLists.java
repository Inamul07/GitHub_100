// url: https://leetcode.com/problems/merge-two-sorted-lists/submissions/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode trav = head;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                trav.next = l1;
                l1 = l1.next;
            } else {
                trav.next = l2;
                l2 = l2.next;
            }
            trav = trav.next;
        }
        if(l1 == null)
            trav.next = l2;
        else
            trav.next = l1;
        return head.next;
    }
}
