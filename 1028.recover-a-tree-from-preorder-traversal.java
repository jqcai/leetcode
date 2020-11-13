import java.util.*;

/*
 * @lc app=leetcode id=1028 lang=java
 *
 * [1028] Recover a Tree From Preorder Traversal
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> st = new Stack<>();
        int dep = 0;
        int node = 0;
        TreeNode ans = null;
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                node = node * 10 + (c - '0');
                continue;
            } else if (c == '-') {
                // System.out.println(node);
                if (dep == 0) {
                    ans = new TreeNode(node);
                    st.push(ans);
                } else if (node > 0) {
                    while (dep < st.size()) {
                        st.pop();
                    }
                    TreeNode tmp = st.peek();
                    TreeNode newNode = new TreeNode(node);
                    if (tmp.left != null) {
                        tmp.right = newNode;
                        // st.pop();
                    } else {
                        tmp.left = newNode;
                    }
                    st.push(newNode);
                    dep = 0;
                }
                node = 0;
                dep++;
            }
        }
        if (dep == 0) {
            ans = new TreeNode(node);
        } else if (node > 0) {
            while (dep < st.size()) {
                st.pop();
            }
            TreeNode tmp = st.peek();
            TreeNode newNode = new TreeNode(node);
            if (tmp.left != null) {
                tmp.right = newNode;
            } else {
                tmp.left = newNode;
            }
        }
        return ans;
    }
}
