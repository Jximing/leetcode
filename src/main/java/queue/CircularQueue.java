package queue;

import java.util.List;
import java.util.Queue;

public class CircularQueue {

    private Integer[] data;
    private int tail;
    private int head;
    private int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        tail = 0;
        head = 0;
        size=k;
        data = new Integer[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        data[head]=value;
        head = (head + 1) % size;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
           return false;
        }
        data[tail] = null;
        tail = (tail + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[tail];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[head==0?size-1:head-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == tail && data[head]==null;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return head == tail && data[head]!=null;
    }
}
