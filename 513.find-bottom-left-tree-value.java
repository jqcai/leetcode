/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
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
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> traverse = new LinkedList<>();
        traverse.add(null);
        traverse.add(root);
        int ans = 0;
        while(traverse.size() > 0){
            TreeNode tmp = traverse.pollFirst();
            if(tmp==null && traverse.size() > 0){
                ans = traverse.peekFirst().val;
                traverse.add(null);
            }
            if(tmp == null){
                continue;
            }
            if(tmp.left!=null){
                traverse.addLast(tmp.left);
            }
            if(tmp.right != null){
                traverse.addLast(tmp.right);
            }
        }
        return ans;
    }
}

