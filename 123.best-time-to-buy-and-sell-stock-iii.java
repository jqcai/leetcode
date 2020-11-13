import java.util.Arrays;
/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int[] buy = new int[2];
        int[] sell = new int[2];
        Arrays.fill(buy, Integer.MIN_VALUE);
        // Arrays.fill(sell, -100000000);
        for(int i:prices) {
            sell[1] = Math.max(sell[1], buy[1] + i);
            buy[1] = Math.max(buy[1], sell[0] - i);
            sell[0] = Math.max(sell[0], buy[0] + i);
            buy[0] = Math.max(buy[0], - i);
        }
        return sell[1];
    }
}

