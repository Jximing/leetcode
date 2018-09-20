package queue;

import java.util.Arrays;

public class SquareNumber {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        //根据4平方和定理结果不可能超过4
        Arrays.fill(dp, 5);
        //将小于n的平方数找出来置1（1步就到）
        for (int i = 0; i * i <=n; i++) {
            dp[i*i] = 1;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                //对每一个i,步数=dp[i-j*j]+dp[j*j](1) 从小到大的数全部都取的最小
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
