package leetcode.BestTimeToBuyAndSellStockII;

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0 ; i < prices.length -1 ; i++ ){
            int j = i + 1;
            int value = prices[j] - prices[i];
            if(value > 0){
                profit += value;
            }
        }

        return profit;
    }
}
