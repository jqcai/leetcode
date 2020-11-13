/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */
class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            sb.append(c);
            sb.append('#');
        }
        sb.deleteCharAt(sb.length() - 1);
        int[] dp = new int[sb.length()];
        int farest = 0;
        for(int i = 0; i < sb.length(); i++){
            for(int j = farest - i; j < Math.min(sb.length() - i, i); j++){
                if(sb.charAt(i + j) == sb.charAt(i - j)){
                    dp[i] += 1;
                }
            }
        }
    }
}

