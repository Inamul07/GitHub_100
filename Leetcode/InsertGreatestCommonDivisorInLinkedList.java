// url: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/

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

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode trav = head;
        while(trav.next != null) {
            int a = trav.val, b = trav.next.val;
            ListNode next = trav.next, newNode = new ListNode(gcd(Math.max(a, b), Math.min(a, b)));
            trav.next = newNode;
            newNode.next = next;
            trav = trav.next.next;
        }
        return head;
    }
}
