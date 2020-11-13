import java.util.*;
/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode tn = queue.poll();
                if(tn.left != null){
                    queue.add(tn.left);
                }
                if(tn.right != null){
                    queue.add(tn.right);
                }
                if(i == size - 1){
                    ans.add(tn.val);
                }
            }
        }
        return ans;
        
    }
}

