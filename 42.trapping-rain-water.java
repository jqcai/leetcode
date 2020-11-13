/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int start = 0, end = height.length - 1;
        int bound = Math.min(height[start], height[end]);
        int water = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                water += bound - height[start];
                start++;
                
            }else{
                water += bound - height[end];
                end --;
            }
            bound = Math.max(bound, Math.min(height[start], height[end]));
        }
        return water + bound - height[start];
    }
}
