// import java.util.*;
/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        if(A == null || A.length == 0 || K == 0){
            return 0;
        }
        K = Math.abs(K);
        int sum = 0;
        int total = 0;
        int[] count = new int[K];
        count[0] ++;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            sum = ((sum % K) + K) % K;
            total += count[sum];
            count[sum] ++;
        }
        return total;
    }
}

