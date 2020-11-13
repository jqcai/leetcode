import java.util.Stack;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        int pre = 0;
        if(st.size() > 0){
            pre = st.peek().val;
            TreeNode tn = st.pop();
            tn = tn.right;
            while(tn != null) {
                st.push(tn);
                tn = tn.left;
            }
        }
        while (!st.isEmpty()) {
            TreeNode tn = st.pop();
            if(tn.val <= pre){
                return false;
            }
            pre = tn.val;
            tn = tn.right;
            while(tn != null){
                st.push(tn);
                tn = tn.left;
            }
        }
        return true;
    }
}
