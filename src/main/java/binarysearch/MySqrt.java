package binarysearch;

public class MySqrt {

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left<=right){
            long mid = (left+right)/2;
            long t = mid+1;
            if(mid*mid<=x&&t*t>x){
                return (int)mid;
            }else if(mid*mid>x){
                right = mid-1;
            }else {
                left  = mid + 1;
            }
        }
        return 0;
    }

    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int ans = 0;
        int left = 0;
        int right = x;
        while (left != right) {
            int tmp = (left+right)/2;
            if(tmp <= x/tmp){
                left = tmp+1;
            }else {
                right = tmp;
            }
        }
        return left-1;
    }

    public static void main(String[] args){
        MySqrt ms = new MySqrt();
        System.out.print(ms.mySqrt(2147395600));
    }
}
