import java.util.*;

/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2)
            return quickSolve(prices);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i : prices) {
            for (int j = k; j > 0; j--) {
                sell[j] = Math.max(buy[j] + i, sell[j]);
                buy[j] = Math.max(buy[j], sell[j - 1] - i);
            }
        }
        return sell[k];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }
}
