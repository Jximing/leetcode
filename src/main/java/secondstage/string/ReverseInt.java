package secondstage.string;

/**
 * @ClassName ReverseInt
 * @Description 整数反转
 * @Author mingjie
 * @Date 2018/12/16 11:33 PM
 * @Versrion 1.0
 **/
public class ReverseInt {

    public int reverse(int x) {
        int res = 0;
        while (x>0){
            if (res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&x>7)){
                res = 0;
                break;
            }
            res = 10*res+x%10;
            x/=10;
        }
        while (x<0){
            if (res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&x<-8)){
                res = 0;
                break;
            }
            res = 10*res+x%10;
            x/=10;
        }
        return res;
    }

    public static void main(String[] args){
        ReverseInt ri = new ReverseInt();
        System.out.print(ri.reverse(1534236469));
    }

}
