import java.util.*;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        if(root.left == null && root.right == null){
            if(sum == root.val){
                List<Integer> tmp = new LinkedList<>();
                tmp.add(sum);
                ans.add(tmp);
                return ans;
            }
            else{
                return ans;
            }
        }
        List<List<Integer>> a = pathSum(root.left, sum - root.val);
        if(root.left != null&& !a.isEmpty()){
            for(List<Integer> b:a){
                List<Integer> tmp = new LinkedList<>();
                tmp.add(root.val);
                tmp.addAll(b);
                ans.add(tmp);
            }
        }
        a = pathSum(root.right, sum - root.val);
        if(root.right != null&& !a.isEmpty()){
            for(List<Integer> b:a){
                List<Integer> tmp = new LinkedList<>();
                tmp.add(root.val);
                tmp.addAll(b);
                ans.add(tmp);
            }
        }
        return ans;
    }
}

