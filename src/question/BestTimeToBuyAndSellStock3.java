package question;

import java.util.Arrays;

/**
 * Created by siren0413 on 1/7/14.
 */
public class BestTimeToBuyAndSellStock3 {


    public static int maxProfit(int[] prices){
        if(prices == null || prices.length == 0)
            return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int buy = prices[0];
        for(int i = 1; i < prices.length; i++){
            left[i] = Math.max(left[i-1],prices[i] - buy);
            buy = Math.min(buy,prices[i]);
        }

        int sell = prices[prices.length-1];
        for(int i = prices.length-2; i>=0;i--){
            right[i] = Math.max(right[i+1],sell - prices[i]);
            sell = Math.max(sell, prices[i]);
        }

        int max = 0;
        for(int i = 0; i < prices.length; i++){
            max = Math.max(max, left[i]+right[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = {3, 1, 2, 5, 0, 2, 4, 7, 2};
        System.out.println(maxProfit(prices));

    }
}
