/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[i] = grid[0][i];
                continue;
            }
            dp[i] = grid[0][i] + dp[i - 1]; 
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    dp[j] += grid[i][j];
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}

