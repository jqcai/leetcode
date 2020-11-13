/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int buy = Integer.MIN_VALUE;
        int[] sell = new int[2];
        for(int i : prices) {
            buy = Math.max(buy, sell[0] - i);
            sell[0] = sell[1];
            sell[1] = Math.max(buy + i, sell[1]);
        }
        return sell[1];
    }
}

