/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {



    // // divide and conque solution
    // int max = Integer.MIN_VALUE;

    // public int maxSubArray(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     helper(nums, 0, nums.length - 1);
    //     return max;
    // }

    // public int[] helper(int[] nums, int start, int end) {
    //     // if(start > end) {
    //     // return new int[]{0,0};
    //     // }
    //     if (start == end) {
    //         max = Math.max(max, nums[start]);
    //         return new int[] { nums[start], nums[start], nums[start]};
    //     }
    //     int mid = (start + end) / 2;
    //     int[] left = helper(nums, start, mid);
    //     int[] right = helper(nums, mid + 1, end);
    //     int midMax = 0;
    //     if (left[1] < 0 && right[0] < 0) {
    //         midMax = Math.max(left[1], right[0]);
    //     } else {
    //         midMax = Math.max(0, left[1]) + Math.max(right[0], 0);
    //     }
    //     max = Math.max(midMax, max);
    //     return new int[]{Math.max(left[0], left[2] + right[0]), Math.max(right[1], right[2] + left[1]), left[2] + right[2]};
    // }
    

    // dp solution
    public int maxSubArray(int[] nums) {
        int total_max = Integer.MIN_VALUE;
        int right_max = 0;
        for(int i:nums) {
            right_max += i;
            total_max = Math.max(total_max, right_max);
            if(right_max < 0){
                right_max = 0;
            }
        }
        return total_max;
    }
}
