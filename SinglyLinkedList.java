package SinglyLinkedList;


public class SinglyLinkedList {
    Node head;
    Node tail;
    
    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
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
            head = newNode;
        }
    }

    public void addAfter(int element, int newElement) {
        Node newNode = new Node(newElement);
        Node trav1 = head;
        while(trav1 != null) {
            Node trav2 = trav1.next;
            if(trav1.val == element) {
                trav1.next = newNode;
                newNode.next = trav2;
                break;
            }
            trav1 = trav1.next;
        }
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        Node trav1 = head;
        while(trav1 != null) {
            Node trav2 = trav1.next;
            if(trav2.next == tail) {
                tail = trav2;
                trav2.next = null;
            }
            trav1 = trav2;
        }
    }

    public void remove(int element) {
        if(head.val == element)
            removeFirst();
        else if(tail.val == element)
            removeLast();
        else {
            Node trav1 = head;
            while(trav1 != null) {
                Node trav2 = trav1.next;
                if(trav2.val == element) {
                    trav1.next = trav2.next;
                    break;
                }
                trav1 = trav2;
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
        System.out.print("]\n");
    }
}