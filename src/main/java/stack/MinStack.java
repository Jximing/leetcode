package stack;

import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.Arrays;

class MinStack {

    /**
     * initialize your data structure here.
     */
    private int[] data;
    private int length = 16;
    private int size = 0;
    public MinStack() {
        data = new int[length];
    }

    public void push(int x) {
        checkIsFull();
        data[size++] = x;
    }

    public void pop() {
        size--;
    }

    public int top() {
        if(size==0){
            return 0;
        }
        return data[size-1];
    }

    public int getMin() {
        int temp = Integer.MAX_VALUE;
        for (int i=0;i<size;i++){
            temp = Math.min(temp,data[i]);
        }
        return temp;
    }

    private void checkIsFull(){
        if(length==size){
            data=Arrays.copyOf(data,length<<=1);
        }
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