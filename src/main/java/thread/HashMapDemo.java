package thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mingjie
 * @ClassName HashMapDemo
 * @description TODO
 * @date 2020/6/7 17:13
 * @versrion 1.0
 **/
public class HashMapDemo {

    public static void main(String[] args) {

        Map<test,Integer> map = new HashMap<>(32);

        for (int i = 0; i < 18; i++) {
            map.put(new test(),i);
        }
        System.out.println(map);

    }

    static class test{

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }
}
