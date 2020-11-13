import java.util.Arrays;

/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int j = nums.length - 1; j >= 2; j--) {
            sum += helper(nums, 0, j - 1, nums[j]);
        }
        return sum;
        
    }
    public int helper(int[] nums, int start, int end, int longest){
        int sum = 0;
        while(start < end) {
            if(nums[start] + nums[end] > longest) {
                sum += end - start;
                end--;
            }else{
                start ++;
            }
        }
        return sum;
    }
}

