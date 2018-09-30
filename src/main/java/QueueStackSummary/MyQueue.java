package QueueStackSummary;

import java.util.Stack;

class MyQueue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(T x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public T pop() {
        T result = null;
        while (!stack1.isEmpty()) {
            result = stack1.pop();
            if (!stack1.isEmpty()) stack2.push(result);
        }
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public T peek() {
        T result = null;
        while (!stack1.isEmpty()) {
            result = stack1.pop();
            stack2.push(result);
        }
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
