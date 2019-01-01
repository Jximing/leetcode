package secondstage.string;


/**
 * @ClassName MyAtoi
 * @Description 字符串转换整数 (atoi)
 * @Author mingjie
 * @Date 2018/12/22 9:16 AM
 * @Versrion 1.0
 **/
public class MyAtoi {

    public int myAtoi(String str) {
        if (str.trim().isEmpty()) return 0;
        int sign = 1, base = 0, i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') ++i;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }

    public static void main(String[] args) {
        MyAtoi ma = new MyAtoi();
        System.out.print(ma.myAtoi(" "));

    }
}
