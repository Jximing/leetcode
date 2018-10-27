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

    public static void main(String[] args){
        MySqrt ms = new MySqrt();
        System.out.print(ms.mySqrt(2147395600));
    }
}
