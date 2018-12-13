package firststage.Array.Summary;

public class ReverseWordII {

    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        int temp = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i <= arr.length; i++) {
            if (end<arr.length&&arr[i] != ' ') {
                end++;
                continue;
            }
            start = temp;
            temp = end + 1;
            end--;
            while (start < end) {
                char _t = arr[start];
                arr[start++] = arr[end];
                arr[end--] = _t;
            }
            end = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseWordII rw = new ReverseWordII();
        String s = "Let's take LeetCode contest";
        System.out.println(rw.reverseWords(s));
    }

}
