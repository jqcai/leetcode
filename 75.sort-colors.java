/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */
class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, pr = 0;
        while(pr <= p2){
            if(nums[pr] == 0){
                nums[pr] = nums[p1];
                nums[p1] = 0;
                p1++;
                pr++;
            }else if(nums[pr] == 2){
                nums[pr] = nums[p2];
                nums[p2] = 2;
                p2 --;
            }else if(nums[pr]==1){
                pr ++;
            }
        }
    }
}

