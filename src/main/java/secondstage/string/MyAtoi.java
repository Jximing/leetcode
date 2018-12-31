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
        char[] arr = str.toCharArray();
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == '-' || arr[i] == '+' || arr[i] >= '0' && arr[i] <= '9') {
                break;
            }
        }
        int num = 0;
        for (; i < arr.length; i++) {

            num += arr[i] * 10;
        }
        return num;
    }
}
