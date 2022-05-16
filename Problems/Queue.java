package Queue;

public class Queue {
    
    Node head;
    Node tail;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public Queue() { }

    public Queue(int element) {
        enqueue(element);
    }

    public void enqueue(int element) {
        Node newNode = new Node(element);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int dequeue() {
        int element = head.val;
        head = head.next;
        return element;
    }

    public boolean isEmpty() {
        if(head == null)
            return true;
        return false;
    }

    public void print() {
        Node trav = head;
        System.out.print("[");
        while(trav != null) {
            System.out.print(trav.val + ", ");
            trav = trav.next;
        }
        System.out.println("]");
    }
}
