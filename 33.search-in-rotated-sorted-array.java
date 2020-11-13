/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            // System.out.println(start + " " + end + " " + mid);
            if(nums[mid] == target){
                // System.out.println(123);
                start = end = mid;
                // System.out.println(start + " " + end + " " + mid);
            }else if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            // System.out.println(start + " " + end);
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
