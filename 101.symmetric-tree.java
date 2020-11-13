/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while(q1.size() > 0 && q2.size() > 0){
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if(t1 == null && t2 == null){
                continue;
            }else if(t1 == null || t2 == null){
                return false;
            }else{
                if(t1.val != t2.val){
                    return false;
                }
                q1.add(t1.left);
                q1.add(t1.right);
                q2.add(t2.right);
                q2.add(t2.left);
            }
        }
        return q1.size() == q2.size();
    }
}

