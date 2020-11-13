import java.util.*;

import javafx.util.Pair;
/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(root, 0));
        queue.add(new Pair<TreeNode, Integer>(null, 0));
        int min = -1;
        int max_width = 0;
        while(queue.size() > 0){
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode n = p.getKey();
            int v = p.getValue();
            if(n!= null){
                if(min == -1){
                    min = v;
                }else{
                    max_width = Math.max(max_width, v - min);
                }
                if(n.left !=null){
                    queue.add(new Pair<TreeNode, Integer>(n.left, v << 1));
                }
                if(n.right != null){
                    queue.add(new Pair<TreeNode, Integer>(n.right, (v << 1) + 1));
                }
            }else{
                if(queue.size() == 0){
                    break;
                }
                min = -1;
                queue.add(new Pair<TreeNode, Integer>(null, 0));
            }
        }
        return max_width + 1;

    }
}

