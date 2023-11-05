package thirdstage;

public class Solutions {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 例如，121 是回文，而 123 不是。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int r = 0;
        int mid = x;
        while (mid > 0) {
            r = r * 10 + mid % 10;
            mid = mid / 10;
        }
        return r == x;
    }
}
