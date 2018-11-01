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

    public static void main(String[] args){
        MyPow mp = new MyPow();
        System.out.println(mp.myPow(2.0,2));
    }
}
