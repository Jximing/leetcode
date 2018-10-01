package queuestacksummary;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> support;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
        support = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue.isEmpty()) {
            queue.offer(x);
        } else {
            while (!queue.isEmpty()) {
                support.offer(queue.poll());
            }
            queue.offer(x);
            while (!support.isEmpty()){
                queue.offer(support.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
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