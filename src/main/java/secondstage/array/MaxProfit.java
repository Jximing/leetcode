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


    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit(prices));
    }
}
