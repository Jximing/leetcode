package thread;

/**
 * @author mingjie
 * @ClassName VolatileDemo
 * @description TODO
 * @date 2020/5/30 12:37
 * @versrion 1.0
 **/
public class VolatileDemo {

    private volatile int a = 0;

    public void print(){
//        while (true){
//            System.out.print(a+"，");
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                System.out.println("print finished");
//                return;
//            }
//        }
        while (!Thread.interrupted()){
            System.out.print(a+"，");
        }
    }

    public void setA(int a){
        this.a = a;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo  = new VolatileDemo();
        Thread a = new Thread(demo::print);
        a.start();
        Thread b = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                demo.setA(i);
                System.out.println("写入a："+i);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//
//                }
            }
        });
        b.start();
        b.join();
        System.out.println("执行完毕");
        a.interrupt();
    }
}
