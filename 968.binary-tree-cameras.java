import java.util.*;

/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
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
    public int minCameraCover(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        
    }
    public int helper(Map<TreeNode, Integer> map, TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        
    }
}

