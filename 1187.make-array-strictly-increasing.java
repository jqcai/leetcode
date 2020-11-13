import java.util.Arrays;

/*
 * @lc app=leetcode id=1187 lang=java
 *
 * [1187] Make Array Strictly Increasing
 */

// @lc code=start
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if(arr1.length == 0){
            return 0;
        }
        Arrays.sort(arr2);
    }
}
// @lc code=end

