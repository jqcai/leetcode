/*
 * @lc app=leetcode id=663 lang=java
 *
 * [663] Equal Tree Partition
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
    public boolean checkEqualTree(TreeNode root) {
        Set<Integer> sums = new HashSet<>();
        int total = sum(root, sums);
        // System.out.println(total);
        if((total & 1) == 1 || !sums.contains(total/2)){
            return false;
        }
        return true;
    }
    public int sum(TreeNode root, Set<Integer> sums){
        if(root == null){
            return 0;
        }else{
            int left = sum(root.left, sums);
            if(root.left != null){
                sums.add(left);
            }
            int right = sum(root.right, sums);
            if(root.right != null){
                sums.add(right);
            }
            return root.val + left + right;
        }
    }
}

