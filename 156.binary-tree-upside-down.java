import java.util.*;
/*
 * @lc app=leetcode id=156 lang=java
 *
 * [156] Binary Tree Upside Down
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null){
            return root;
        }
        Stack<TreeNode> st = new Stack<>();
        while(root != null){
            st.push(root);
            root = root.left;
        }
        root = st.pop();
        TreeNode parent = root;
        while(st.size() > 0){
            TreeNode tmp = st.pop();
            parent.right = tmp;
            parent.left = tmp.right;
            tmp.left = null;
            tmp.right = null;
            parent = tmp;
        }
        return root;
    }
}

