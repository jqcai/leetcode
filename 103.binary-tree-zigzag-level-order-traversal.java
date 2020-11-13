import java.util.*;
/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        while(deque.size() > 0){
            int size = deque.size();
            List<Integer> traverse = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode tmp = deque.pollFirst();
                traverse.add(tmp.val);
                if(tmp.left != null){
                    deque.addLast(tmp.left);
                }
                if(tmp.right != null){
                    deque.addLast(tmp.right);
                }
            }
            ans.add(traverse);
            if(deque.size() > 0){
                size = deque.size();
                traverse = new LinkedList<>();
                for(int i = 0; i < size; i++){
                    TreeNode tmp = deque.pollLast();
                    traverse.add(tmp.val);
                    if(tmp.right != null){
                        deque.addFirst(tmp.right);
                    }
                    if(tmp.left != null){
                        deque.addFirst(tmp.left);
                    }
                }
                ans.add(traverse);
            }
        }
        return ans;
    }
}

