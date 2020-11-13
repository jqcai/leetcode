/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int p1 = 0, p2 = 0;
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        while(p2 < nums.length){
            sum += nums[p2];
            p2++;
            while(sum >= s && p1 < p2){
                min_len = Math.min(p2 - p1, min_len);
                sum -= nums[p1];
                // System.out.println(p1);
                p1++;
            }
        }
        if(min_len == Integer.MAX_VALUE){
            return 0;
        }
        return min_len;
    }
}

