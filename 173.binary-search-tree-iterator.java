import java.util.*;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }

    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tn = st.pop();
        int val = tn.val;
        tn = tn.right;
        while (tn != null) {
            st.push(tn);
            tn = tn.left;
        }
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return st.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
