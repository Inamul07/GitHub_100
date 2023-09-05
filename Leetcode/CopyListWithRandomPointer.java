// url: https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node trav = head.next, newHead = new Node(head.val), tmp = newHead;
        map.put(head, newHead);
        while(trav != null) {
            tmp.next = new Node(trav.val);
            tmp = tmp.next;
            map.put(trav, tmp);
            trav = trav.next;
        }
        trav = head; tmp = newHead;
        while(trav != null) {
            tmp.random = map.get(trav.random);
            tmp = tmp.next;
            trav = trav.next;
        }
        return newHead;
    }
}
