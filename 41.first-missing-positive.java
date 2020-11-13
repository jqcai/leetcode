/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean flag1 = false;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] <= 0){
                nums[i] = 1;
            }else if(nums[i] > nums.length){
                nums[i] = 1;
            }else if(nums[i] == 1){
                flag1 = true;
            }
        }
        if(!flag1){
            return 1;
        }
        // System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++){
            // System.out.println(nums[i]);
            nums[Math.abs(nums[i]) - 1] = - Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}

