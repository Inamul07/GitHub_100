// url: https://leetcode.com/problems/add-two-numbers-ii/

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
        ListNode trav1 = l1, trav2 = l2;
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        Stack<ListNode> resStack = new Stack<>();
        while(trav1 != null) {
            stack1.add(trav1.val);
            trav1 = trav1.next;
        }
        while(trav2 != null) {
            stack2.add(trav2.val);
            trav2 = trav2.next;
        }
        int carry = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            int res = stack1.pop() + stack2.pop() + carry;
            if(carry == 1) carry = 0;
            if(res > 9) carry = 1;
            res %= 10;
            resStack.add(new ListNode(res));
        }
        while(!stack1.isEmpty()) {
            int res = stack1.pop() + carry;
            if(carry == 1) carry = 0;
            if(res > 9) carry = 1;
            res %= 10;
            resStack.add(new ListNode(res));
        }
        while(!stack2.isEmpty()) {
            int res = stack2.pop() + carry;
            if(carry == 1) carry = 0;
            if(res > 9) carry = 1;
            res %= 10;
            resStack.add(new ListNode(res));
        }
        if(carry == 1) resStack.add(new ListNode(1));
        ListNode head = resStack.pop(), trav = head;
        while(!resStack.isEmpty()) {
            trav.next = resStack.pop();
            trav = trav.next;
        }
        return head;
    }
}
