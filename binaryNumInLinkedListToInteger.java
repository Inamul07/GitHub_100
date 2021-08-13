// url: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

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
    public int getDecimalValue(ListNode head) {
        ListNode trav = head;
        int size = -1;
        while(trav != null) {
            size++;
            trav = trav.next;
        }
        int sum = 0;
        trav = head;
        while(trav != null) {
            sum += trav.val * Math.pow(2, size);
            size--;
            trav = trav.next;
        }
        return sum;
    }
}
