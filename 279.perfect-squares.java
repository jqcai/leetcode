import java.util.Arrays;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */
class Solution {
    public int numSquares(int n) {
        if(n < 2) {
            return n;
        }
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        for(int i = 1; i <= n; i++){
            int j = 1;
            while(i >= j * j && ans[i - j * j] < Integer.MAX_VALUE){
                ans[i] = Math.min(ans[i], ans[i - j * j] + 1);
                j++;
            }
        }
        // System.out.println(Arrays.toString(ans));
        return ans[n];
    }
}

