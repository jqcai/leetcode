/*
 * @lc app=leetcode id=1000 lang=java
 *
 * [1000] Minimum Cost to Merge Stones
 */
class Solution {
    public int mergeStones(int[] stones, int K) {
        if (stones.length == 0) {
            return -1;
        }
        int[] preSum = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            // System.out.println(i);
            preSum[i + 1] = preSum[i] + stones[i];
        }
        // System.out.println(Arrays.toString(preSum));
        if (K <= 1) {
            return -1;
        }
        if (K != 2 && stones.length % (K - 1) != 1) {
            return -1;
        }
        int[][] dp = new int[stones.length][stones.length];
        for (int i = 0; i < stones.length; i++) {
            for (int j = i - K + 1; j >= 0; j--) {
                int sum = 0;
                if ((i - j + 1) % (K - 1) == 1 || K == 2) {
                    sum += preSum[i + 1] - preSum[j];
                }
                int minSplit = Integer.MAX_VALUE;
                for (int k = j; k < i; k++) {
                    if ((k - j) % (K - 1) + (i - k - 1) % (K - 1) >= K - 1) {
                        continue;
                    }
                    minSplit = Math.min(minSplit, dp[j][k] + dp[k + 1][i]);
                    // System.out.println(minSplit);
                }
                minSplit = minSplit == Integer.MAX_VALUE ? 0 : minSplit;
                sum += minSplit;
                // System.out.println(sum);
                dp[j][i] = sum;

            }
        }
        return dp[0][stones.length - 1];
    }
}
