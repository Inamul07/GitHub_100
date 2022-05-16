package DoublyLinkedList;

public class DoublyLinkedList {

    Node head;
    Node tail;

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAfter(int element, int newElement) {
        Node newNode = new Node(newElement);
        if(tail.val == element)
            addLast(newElement);
        else {
            Node trav1 = head;
            while(trav1 != null) {
                Node trav2 = trav1.next;
                if(trav1.val == element) {
                    trav1.next = newNode;
                    newNode.next = trav2;
                    newNode.prev = trav1;
                    trav2.prev = newNode;
                }
                trav1 = trav1.next;
            }
        }
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFirst() {
        head = head.next;
        head.prev = null;
    }

    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
    }

    public void remove(int element) {
        if(head.val == element) 
            removeFirst();
        else if(tail.val == element)
            removeLast();
        else {
            Node trav = head.next;
            while(trav != null) {
                if(trav.val == element) {
                    Node temp1 = trav.prev;
                    Node temp2 = trav.next;
                    temp1.next = temp2;
                    temp2.prev = temp1;
                }
                trav = trav.next;
            }
        }
    }
    
    public void clear() {
        head = null;
        tail = null;
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
