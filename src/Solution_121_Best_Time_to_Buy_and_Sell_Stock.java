/**
 * 
 * Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 *
 */
/*
 * Notice: 
 */
public class Solution_121_Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int buydate = 0;
        int result = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[buydate] > prices[i]) {
                buydate = i;
            }
            int temp = prices[i] - prices[buydate];
            if (temp > result) {
                result = temp;
            }
        }
        
        return result;
    }
}
