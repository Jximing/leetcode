package secondstage.array;

/**
 * @ClassName MaxProfit
 * @Description 买卖股票的最佳时机 II
 * @Author mingjie
 * @Date 2018/12/13 11:06 PM
 * @Versrion 1.0
 **/
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0;i<prices.length-1;){
            int j = i+1;
            while (j<prices.length&&prices[j]>prices[j-1]){
                j++;
            }
            if(j==prices.length-1&&prices[j]>prices[j-1]){
                profit+=prices[j]-prices[i];
            }else {
                profit+= prices[j-1]-prices[i];
            }
            i=j;
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length <=1) {
            return 0;
        }
        int max = 0, tmp;
        // 没有买入卖出的限制，直接和第二天比较价格就是利润
        for(int i=0;i<prices.length-1; i++) {
            if ((tmp = prices[i + 1] - prices[i]) > 0) {
                max += tmp;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit(prices));
    }
}
