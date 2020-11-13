/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }
        // boolean reverse = true;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                nums[i] ^= nums[i-1];
                nums[i-1] ^= nums[i];
                nums[i] ^= nums[i-1];
                return;
            }
        }
        for(int i = 0; i < nums.length/2; i++){
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
        return;
    }
}

