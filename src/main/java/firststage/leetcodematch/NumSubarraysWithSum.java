package firststage.leetcodematch;

public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if(A.length==1){
            if(A[0]==S){
                return 1;
            }else {
                return 0;
            }
        }
        int start = 0,end = 1,count = 0;
        while (start<end&&end<A.length){
            if(calculat(A,start,end)==S){
                count++;
                int count1 = 0;
                int tend = end;
                while (end<A.length-1&&A[++end]==0){
                    count1++;
                }
                count1 = count1==0?1:count1;
                while (start<tend&&A[++start]==0){
                    count+=count1;
                }
            }else if(calculat(A,start,end)<S){
                end++;
            }else {
                start++;
            }
        }
        return count;
    }

    private int calculat(int[] A,int start,int end){
        int sum = 0;
        for (;start<=end;start++){
            sum+=A[start];
        }
        return sum;
    }

    public int numSubarraysWithSum1(int[] a, int S) {
        int n = a.length;
        //i之前有多少个1
        int[] cum = new int[n+1];
        for(int i = 0;i < n;i++)cum[i+1] = cum[i] + a[i];

        int ret = 0;

        int[] f = new int[n+1];
        for(int i = 0;i <= n;i++){
            if(cum[i]-S >= 0){
                //出现次数就等于cum[i]-S出现的次数
                ret += f[cum[i]-S];
            }
            //记录i之前各种结果出现的次数
            f[cum[i]]++;
        }
        return ret;
    }
    public static void main(String[] args){
        NumSubarraysWithSum nsws = new NumSubarraysWithSum();
        int[] A = {0,0,0,0,0};
        System.out.print(nsws.numSubarraysWithSum1(A,0));
    }
}
