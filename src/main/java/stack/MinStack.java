package stack;

import sun.dc.pr.PRError;

import java.util.ArrayList;

class MinStack {

    /**
     * initialize your data structure here.
     */
    private ArrayList<Integer> date;
    private int current;
    public MinStack() {
        date = new ArrayList<Integer>();
        current=0;
    }

    public void push(int x) {
        date.add(current++,x);
        ;
    }

    public void pop() {
        date.remove(--current);
    }

    public int top() {
        return date.get(current-1);
    }

    public int getMin() {
        int temp = Integer.MAX_VALUE;
        for (int a:date) {
            temp=Math.min(temp,a);
        }
        return temp;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */