// url: https://leetcode.com/problems/split-linked-list-in-parts/

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode trav = head;
        while(trav != null) {
            len++;
            trav = trav.next;
        }
        int defVal = len / k, extraVal = len % k;
        trav = head;
        for(int i = 0; i < k; i++) {
            res[i] = trav;
            int c = defVal;
            if(i < extraVal) c++;
            while(c-- > 1) trav = trav.next; 
            if(trav == null) continue;
            ListNode next = trav.next;
            trav.next = null;
            trav = next;
        }
        return res;
    }
}
