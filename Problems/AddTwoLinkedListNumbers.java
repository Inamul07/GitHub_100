// url: https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode trav = head;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            trav.next = new ListNode(sum % 10);
            trav = trav.next;
            l1 = l1.next;
            l2 = l2.next;
            if(sum > 9 && l1 == null && l2 == null)
                trav.next = new ListNode(1);
            else if(sum > 9 && l2 == null)
                l1.val += 1;
            else if(sum > 9 && l1 == null)
                l2.val += 1;
            else if(sum > 9)
                l1.val += 1;
        }
        while(l1 != null) {
            trav.next = new ListNode(l1.val % 10);
            trav = trav.next;
            if(l1.val > 9 && l1.next == null)
                trav.next = new ListNode(1);
            else if(l1.val > 9)
                l1.next.val += 1;
            l1 = l1.next;
        }
        while(l2 != null) {
            trav.next = new ListNode(l2.val % 10);
            trav = trav.next;
            if(l2.val > 9 && l2.next == null)
                trav.next = new ListNode(1);
            else if(l2.val > 9)
                l2.next.val += 1;
            l2 = l2.next;
        }
        return head.next;
    }
}
