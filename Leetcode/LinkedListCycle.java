// url: https://leetcode.com/problems/linked-list-cycle/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    Set<ListNode> set = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        while(head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }
        if(head == null) return false;
        return true;
    }
}
