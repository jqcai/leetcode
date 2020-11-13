/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int i : prices) {
            buy = Math.max(buy, sell - i);
            sell = Math.max(sell, buy + i - fee);
        }
        return sell;
    }
}
