import java.util.*;
/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        TreeNode pre = dummy;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            pre.right = st.pop();
            if(pre.right == null){
                continue;
            }
            pre = pre.right;
            st.push(pre.right);
            st.push(pre.left);
            pre.left = null;
            pre.right = null;
        }
        return;
    }
}

