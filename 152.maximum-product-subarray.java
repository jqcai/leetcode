/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int rightMax = 1;
        int rightMin = 1;
        for(int i:nums) {
            rightMax *= i;
            rightMin *= i;
            if(rightMax < rightMin){
                int tmp = rightMin;
                rightMin = rightMax;
                rightMax = tmp;
            }
            max = Math.max(rightMax, max);
            if(rightMax <= 0) {
                rightMax = 1;
            }
            if(rightMin >= 0) {
                rightMin = 1;
            }
        }
        return max;
    }
}

