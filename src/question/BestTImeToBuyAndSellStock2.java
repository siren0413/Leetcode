package question;

/**
 * Created by siren0413 on 1/7/14.
 */
public class BestTImeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices){
        if(prices == null || prices.length == 0)
            return 0;
        int max = 0;
        for(int i = 0 ; i < prices.length-1; i ++){
            if(prices[i+1] - prices[i] > 0)
                max += prices[i+1] - prices[i];
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {3,1,2,5,0,2,4,2,7};
        System.out.println(maxProfit(prices));
    }
}
