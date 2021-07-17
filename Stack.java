package Stack;

public class Stack<T> {

    Node top;

    class Node {
        T val;
        Node next;

        public Node(T val) {
            this.val = val;
            next = null;
        }
    }

    public Stack() { }

    public Stack(T element) {
        push(element);
    }

    public void push(T element) {
        Node newNode = new Node(element);
        if(top == null)
            top = newNode;
        else {
            newNode.next = top;
            top = newNode;
        }
    }

    public T pop() {
        T element = top.val;
        top = top.next;
        return element;
    }

    public boolean isNull() {
        if(top == null)
            return true;
        return false;
    }

    public T peek() {
        return top.val;
    }

    public void print() {
        Node trav = top;
        while(trav != null) {
            System.out.println(trav.val);
            trav = trav.next;
        }
    }

    
}