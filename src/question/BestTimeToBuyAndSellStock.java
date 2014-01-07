package question;

/**
 * Created by siren0413 on 1/7/14.
 */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices){
        if(prices == null || prices.length==0)
            return 0;
        int max = Integer.MIN_VALUE;
        int buy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < buy)
                buy = prices[i];
            int profit = prices[i] - buy;
            if(profit > max)
                max = profit;
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {3,1,2,5,0,2,4,2,7};
        System.out.println(maxProfit(prices));
    }


}
