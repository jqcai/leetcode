/*
 * @lc app=leetcode id=829 lang=java
 *
 * [829] Consecutive Numbers Sum
 */
class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        int add = 0;
        while(N > add) {
            if((N - add) % (add + 1) == 0){
                ans ++;
            }
            N -= add++;
        }
        return ans;
    }
}

