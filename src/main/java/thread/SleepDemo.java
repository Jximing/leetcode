package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Semaphore;

/**
 * @author mingjie
 * @ClassName SleepDemo
 * @description TODO
 * @date 2020/6/1 10:56
 * @versrion 1.0
 **/
public class SleepDemo {

    static Semaphore semaphore = new Semaphore(5);

    public static void exec(){
//        System.out.println(Thread.currentThread().getName() + " exec");
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " get permits");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " release");
        }
    }
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread(SleepDemo::exec,"thread"+i).start();
        }
    }

}
