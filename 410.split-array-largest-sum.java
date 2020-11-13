/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length + 1][m];
        for(int i = 0; i < nums.length; i++){
            dp[i + 1][0] = nums[i] + dp[i][0];
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j < m; j++){
                int max = Integer.MAX_VALUE;
                for(int k = i; k >= 0; k--){
                    max = Math.min(max, Math.max(dp[k][j - 1], dp[i + 1][0] - dp[k][0]));
                }
                dp[i][j] = max;
            }
        }
        // for(int[] print:dp){
        //     System.out.println(Arrays.toString(print));
        // }
        return dp[nums.length - m + 1][m - 1];
    }
}

