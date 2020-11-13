/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int m = nums.length;
        int[][] dp = new int[m + 2][m + 2];
        int[] newNum = new int[m + 2];
        for (int i = 0; i < m; i++) {
            newNum[i + 1] = nums[i];
        }
        newNum[0] = newNum[m + 1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j >= 1; j--) {
                if (i == j) {
                    dp[i][i] = newNum[i] * newNum[i - 1] * newNum[i + 1];
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int k = j; k <= i; k++) {
                    max = Math.max(newNum[j - 1] * newNum[k] * newNum[i + 1] + dp[j][k - 1] + dp[k + 1][i], max);
                }
                dp[j][i] = max;
            }
        }
        return dp[1][m];
    }
}
