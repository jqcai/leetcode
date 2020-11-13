/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int swap = find(dp, max, nums[i]);
            if(swap == max){
                max ++;
            }
            dp[swap] = nums[i];
        }
        return max;
    }
    public int find(int[] nums, int len, int target){
        int start = 0, end = len;
        while(start < end){
            int mid = (start + end)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
        // if(start == len || nums[start] > target){
        //     return start;
        // }
        // return start + 1;
    }
}

