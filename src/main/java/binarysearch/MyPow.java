package binarysearch;

public class MyPow {

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        int record = 1;
        double pow = x;
        if(n<0){
            if(n==-2147483648){
                return myPow(x,n/2)*myPow(x,n/2);
            }
            return 1/myPow(x,-n);
        }
        while (record<n&&record>0){
            int temp = n-record;
            if(record<=temp){
                pow=pow*pow;
            }else {
                pow = pow * myPow(x,temp);
            }
            record*=2;
        }
        return pow;
    }


    public  double myPow1(double x, int n) {
        if (n == 0) return 1;
        if(n<0) return 1/x * myPow(1/x, -(n+1));
        if (n == 1) return x;
        if (n == 2) return x*x;

        int absN = n;

        return (n%2 == 0) ? myPow(myPow(x, n/2),2):x*myPow(myPow(x, n/2),2);
    }

    public static void main(String[] args){
        MyPow mp = new MyPow();
        System.out.println(mp.myPow(2.0,2));
    }
}
