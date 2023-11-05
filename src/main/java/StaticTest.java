import java.util.ArrayList;
import java.util.List;

public class StaticTest {


    public static boolean isPalindrome(int x) {
        int r = 0;
        int mid = x;
        while (mid > 0) {
            r = r * 10 + mid % 10;
            mid = mid / 10;
        }
        return r == x;
    }

    public static void main(String[] args) throws InterruptedException {

        isPalindrome(121);

        Item remain = null;
        List<Item> list = new ArrayList() {
            @Override
            protected void finalize() throws Throwable {
                super.finalize();
                System.out.println("GC 回收了list");
            }
        };
        for (int i = 0; i < 10; i++) {
            remain = new Item();
            list.add(remain);
        }

        list = null;
        System.gc();
        Thread.sleep(20000);
        remain.printName();
    }


    static class Item {

        private static int count;

        private final String name;

        public Item() {
            name = "item" + count;
            count++;
        }

        public void printName() {
            System.out.println(name);
        }

        @Override
        protected void finalize() throws Throwable {
            printName();
            super.finalize();
        }
    }
}
