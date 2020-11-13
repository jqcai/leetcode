import java.util.*;
/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        if(nums.length == 0) {
            return ans;
        }
        int n = nums.length;
        int[] segmentTree = new int[n * 2];
        for(int i = 0; i < n; i++){
            segmentTree[n + i] = 
        }



        return ans;
    }
}

