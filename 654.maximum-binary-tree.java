/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }
    public TreeNode construct(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int max_index = -1;
        for(int i = start; i <= end; i++){
            max_index = max_index == -1 ? i : nums[max_index] > nums[i] ? max_index : i; 
        }
        TreeNode root = new TreeNode(nums[max_index]);
        root.left = construct(nums, start, max_index - 1);
        root.right = construct(nums, max_index + 1, end);
        return root;
    }
}

