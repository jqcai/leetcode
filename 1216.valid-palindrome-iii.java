/*
 * @lc app=leetcode id=1216 lang=java
 *
 * [1216] Valid Palindrome III
 */

// @lc code=start
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        if(s.length() == 0 || k >= s.length() - 1){
            return true;
        }
        char[] ch = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++){
            for(int j = i; j >= 0; j--){
                if(i == j){
                    dp[j][i] = 0;
                    continue;
                }
                if(ch[i] == ch[j]){
                    dp[j][i] = dp[j + 1][i - 1];
                }else{
                    dp[j][i] = 1 + Math.min(dp[j + 1][i], dp[j][i - 1]);
                }
            }
        }
        // System.out.println(Arrays.toString(dp[0]));
        return dp[0][s.length() - 1] <= k;
    }
}
// @lc code=end

