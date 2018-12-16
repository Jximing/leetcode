package secondstage.string;

/**
 * @ClassName ReverseInt
 * @Description 整数反转
 * @Author mingjie
 * @Date 2018/12/16 11:33 PM
 * @Versrion 1.0
 **/
public class ReverseInt {

    public int reverse(int x) {
        int res = 0;
        while (x > 0) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && x > 7)) {
                res = 0;
                break;
            }
            res = 10 * res + x % 10;
            x /= 10;
        }
        while (x < 0) {
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && x < -8)) {
                res = 0;
                break;
            }
            res = 10 * res + x % 10;
            x /= 10;
        }
        return res;
    }

    public int reverse1(int x) {
        long result = 0L;

        while (x != 0) {
            int r = x % 10;
            x = x / 10;
            result = result * 10 + r;
        }

        if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;
    }

}
