package firststage.myhash;

public class IsHappy {
    public boolean isHappy(int n) {
        int num;
        int sum = 0;
        boolean[] temp = new boolean[1000];
        while (true) {
            while (n > 0) {
                num = n % 10;
                sum = sum + num * num;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (!temp[sum]) {
                n=sum;
                temp[sum] = true;
                sum = 0;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        IsHappy ih = new IsHappy();
        System.out.println(ih.isHappy(19));
    }
}
