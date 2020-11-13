/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */
class Solution {
    public boolean canJump(int[] nums) {
         int maxJump = 0;
         int start = 0;
         while(start <= maxJump && maxJump < nums.length){
            maxJump = Math.max(maxJump, start + nums[start]);
            start++;
         }
         if(maxJump >= nums.length - 1){
             return true;
         }
         return false;
    }
}

