/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        if(nums.length == 0){
            return ans;
        }
        int start = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1] + 1){
                if(start == nums[i - 1]){
                    ans.add(Integer.toString(start));
                }else{
                    ans.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }
        if(start == nums[nums.length - 1]){
            ans.add(Integer.toString(start));
        }else{
            ans.add(start + "->" + nums[nums.length - 1]);
        }
        return ans;
    }
}

