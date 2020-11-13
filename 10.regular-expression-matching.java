import java.util.Arrays;

/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {
    public boolean isMatch(String s, String p) {
        // if(p.length() == 0 && s.length() == 0){
        //     return true;
        // }else if(p.length() == 0){
        //     return false;
        // }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for(boolean[] tmp:dp){
            Arrays.fill(tmp, false);
        }
        dp[0][0] = true;        
        for(int i = 0; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j ++){
                if(p.charAt(j - 1) == '.'){
                    dp[i][j] = i > 0 && dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    if(j > 1 && dp[i][j - 2]){
                        dp[i][j] = true;
                    }else if(i == 0 || j == 1){
                        dp[i][j] = false;
                    }else{
                        dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                    }
                }else{
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

