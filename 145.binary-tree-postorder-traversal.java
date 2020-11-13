import java.util.*;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeStack = new Stack<>();
        Stack<Integer> label = new Stack<>();
        List<Integer> ans = new LinkedList<>();
        treeStack.push(root);
        label.push(0);
        while(!treeStack.isEmpty()){
            TreeNode tn = treeStack.pop();
            int flag = label.pop();
            if(tn == null){
                continue;
            }
            if(flag == 0) {
                treeStack.push(tn);
                label.push(1);
                treeStack.push(tn.left);
                label.push(0);
            }else if(flag == 1){
                treeStack.push(tn);
                label.push(2);
                treeStack.push(tn.right);
                label.push(0);
            }else{
                ans.add(tn.val);
            }
        }
        return ans;
    }
}

