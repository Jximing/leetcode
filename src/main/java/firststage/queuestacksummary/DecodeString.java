package firststage.queuestacksummary;

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        String res = "";
        char[] arr = s.toCharArray();
        int count = 0;
        for (char a : arr) {
            if (a >= '0' && a <= '9') {
                count = 10 * count + a - '0';
            } else if (a == '[') {
                num.push(count);
                str.push(res);
                count = 0;
                res = "";
            } else if (a == ']') {
                int i = num.pop();
                String tstr = str.pop();
                for (int j = 0; j < i; j++) {
                    tstr += res;
                }
                res = tstr;
            } else {
                res += a;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}


//3[4[a]5[ad]]  abcabcabcabca