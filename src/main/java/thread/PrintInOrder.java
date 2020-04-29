package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mingjie
 * @ClassName PrintInOrder
 * @description The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after first(),
 * and third() is executed after second().
 * @date 2020/4/29 09:30
 * @versrion 1.0
 **/
public class PrintInOrder {

    public static void main(String[] args) {
        Foo f = new Foo();
        Runnable first = () -> {
            System.out.println("first");
        };
        Runnable second = () -> {
            System.out.println("second");
        };
        Runnable third = () -> {
            System.out.println("third");
        };

        Thread t1 = new Thread(() -> {
            try {
                f.first(first);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                f.second(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                f.third(third);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t3.start();
        t1.start();
    }
}


class Foo {

    private volatile int status = 1;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        synchronized (this){
            status++;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this){
            while (status != 2) {
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            status++;
            this.notify();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this){
            while (status != 3) {
                this.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}