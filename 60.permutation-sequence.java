import java.util.*;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ls = new LinkedList<>();
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = dp[i-1]*i;
        }
        for(int i = 1; i <= n; i++){
            ls.add(i);
        }
        StringBuilder sb = new StringBuilder();
        // System.out.println(Arrays.toString(dp));
        for(int i = n - 1; i >= 0; i--){
            sb.append(ls.remove((k-1) / dp[i]));
            // System.out.println(sb.toString());
            k = (k-1)%dp[i] + 1;
        }
        return sb.toString();
    }
}

