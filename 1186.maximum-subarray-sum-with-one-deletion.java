/*
 * @lc app=leetcode id=1186 lang=java
 *
 * [1186] Maximum Subarray Sum with One Deletion
 */

// @lc code=start
class Solution {
    public int maximumSum(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int total_max = arr[0];
        int dp = arr[0];
        int del = Math.min(arr[0], 0);
        for(int i = 1; i < arr.length; i++) {
            System.out.println(dp + " " + del + " " + total_max);
            dp += arr[i];
            del = Math.min(arr[i], del);
            if(dp - del < arr[i]) {
                dp = arr[i];
                del = 0;
            }
            total_max = Math.max(dp - del, total_max);
        }
        return total_max;
    }
}
// @lc code=end

