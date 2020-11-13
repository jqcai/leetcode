/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[start] == nums[mid]){
                start ++;
            }else if(nums[start] < nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}

