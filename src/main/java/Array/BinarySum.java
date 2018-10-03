package Array;

public class BinarySum {

    //多用了个string
    public String addBinary(String a, String b) {
        char[] _a = a.toCharArray();
        char[] _b = b.toCharArray();
        int la = a.length();
        int lb = b.length();
        int sign = 0;
        int length = Math.max(la, lb);
        String res = "";
        for (int i = 0; i < length; i++) {
            int temp = 0;
            if (la > i && _a[la - 1 - i] == '1') {
                temp++;
            }
            if (lb > i && _b[lb - 1 - i] == '1') {
                temp++;
            }
            temp += sign;
            sign = temp / 2;
            res = temp % 2 + res;

        }
        if(sign==1){
            res = "1" +res;
        }
        return res;
    }
    
    /**
     * 别人的更好的解法
     */
    public String addBinary1(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        char[] arr1, arr2;
        if (a.length() >= b.length()) {
            arr1 = a.toCharArray();
            arr2 = b.toCharArray();
        } else {
            arr1 = b.toCharArray();
            arr2 = a.toCharArray();
        }
        int i, j, k;
        for (i = arr1.length - 1, j = arr2.length - 1, k = 0; i > -1; i--, j--) {
            if (j > -1) {
                k = arr1[i] - '0' + arr2[j] - '0' + k;
            } else {
                k = arr1[i] - '0' + k;
            }
            arr1[i] = (char) (k % 2 + '0');
            k /= 2;
        }
        if (k > 0) {
            return 1 + new String(arr1);
        }
        return new String(arr1);
    }
}
