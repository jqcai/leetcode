import java.util.Arrays;

/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start
class Solution {
    public int cherryPickup(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        dp[1][1] = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int x1 = n - 1; x1 >= 0; x1--) {
                int y1 = i - x1;
                if (y1 < 0 || y1 >= n) {
                    continue;
                }
                for (int x2 = n - 1; x2 >= 0; x2--) {
                    int y2 = i - x2;
                    if (y2 < 0 || y2 >= n) {
                        continue;
                    }
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        dp[x1 + 1][x2 + 1] = Integer.MIN_VALUE;
                    } else if (x1 == x2) {
                        dp[x1 + 1][x2 + 1] = grid[x1][y1] + Math.max(Math.max(dp[x1 + 1][x2], dp[x1][x2]),
                                Math.max(dp[x1][x2 + 1], dp[x1 + 1][x2 + 1]));
                    } else {
                        dp[x1 + 1][x2 + 1] = grid[x1][y1] + grid[x2][y2] + Math.max(
                                Math.max(dp[x1 + 1][x2], dp[x1][x2]), Math.max(dp[x1][x2 + 1], dp[x1 + 1][x2 + 1]));
                    }
                }
            }
        }
        return dp[n][n] < 0 ? 0 : dp[n][n];
    }
}
// @lc code=end
