package thread;

import java.util.Random;

/**
 * @author mingjie
 * @ClassName IfTest
 * @description TODO
 * @date 2021/2/6 19:18
 * @versrion 1.0
 **/
public class IfTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        int arraySize = 32768;
        int[] data = new int[arraySize];
        Random rnd = new Random(0);
        for (int i = 0; i < arraySize; i++) 
            data[i] = rnd.nextInt() % 256;
        long start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < arraySize; j++) {
                if(data[j] >= 128)
                    sum += data[j];
            }
        }
        System.out.println((System.nanoTime() - start)/1000000000.0);
        System.out.println(sum);
    }
    public static void test2(){
        int arraySize = 32768;
        int[] data = new int[arraySize];
        Random rnd = new Random(0);
        for (int i = 0; i < arraySize; i++)
            data[i] = rnd.nextInt() % 256;
        long start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < arraySize; j++) {
                if(data[j] >= 128)
                    sum += data[j];
            }
        }
        System.out.println((System.nanoTime() - start)/1000000000.0);
        System.out.println(sum);
    }
}
