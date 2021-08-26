package firststage.stack;

import java.util.Stack;

/**
 * @author mingjie
 * @ClassName StackToQueue
 * @description TODO
 * @date 2020/5/30 09:29
 * @versrion 1.0
 **/
public class StackToQueue<T> {

    Stack<T> in;
    Stack<T> out;

    public StackToQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void offer(T s) {
        in.push(s);
    }

    public T poll() {
        if (!out.isEmpty()) {
            return out.pop();
        }
        if(in.isEmpty()){
            return null;
        }
        while (!in.isEmpty()){
            out.push(in.pop());
        }
        return out.pop();
    }

    public static void main(String[] args) {
        StackToQueue<Integer> queue = new StackToQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.poll());
            queue.offer(5+i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.poll());
        }

    }

}
