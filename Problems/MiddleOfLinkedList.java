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
    public ListNode middleNode(ListNode head) {
        ListNode trav1 = head;
        ListNode trav2 = head;
        while(trav2 != null) {
            if(trav2.next == null) {
                break;
            }
            if(trav2.next.next == null)
                trav2 = trav2.next;
            else
                trav2 = trav2.next.next;
            trav1 = trav1.next;
        }
        return trav1;
    }
}
