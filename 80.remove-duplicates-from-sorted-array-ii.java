/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }
        int p1 = 2, ind = 2;
        for(;ind<nums.length; ind++){
            if(nums[ind] > nums[p1-2]){
                nums[p1] = nums[ind];
                p1++;
            }
        }
        return p1;
    }
}

