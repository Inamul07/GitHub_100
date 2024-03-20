// url: https://leetcode.com/problems/merge-in-between-linked-lists/

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        int idx = 0;
        while(idx <= b) {
            if(idx == a-1) {
                ListNode next = list1.next;
                list1.next = list2;
                list1 = next;
            }
            else list1 = list1.next;
            idx++;
        }
        while(list2.next != null) list2 = list2.next;
        list2.next = list1;
        return head;
    }
}
