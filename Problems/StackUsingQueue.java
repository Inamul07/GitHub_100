// url: https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {
    
    Queue<Integer> list;

    /** Initialize your data structure here. */
    public MyStack() {
        list = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
        for(int i = 0; i < list.size() - 1; i++)
            list.add(list.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return list.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
