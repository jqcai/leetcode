import java.util.*;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode preNode = null;
        TreeNode mist = null;
        TreeNode itr;
        while(root!=null){
            st.push(root);
            root = root.left;
        }
        while(!st.isEmpty()){
            itr = st.pop();
            if(itr == null){
                continue;
            }
            if(preNode != null){
                if(itr.val < preNode.val){
                    if(mist == null){
                        mist = preNode;
                    }else{
                        swap(itr, mist);
                        return;
                    }
                }else if(mist != null && itr.val >= mist.val){
                    swap(preNode, mist);
                    return;
                }
            }
            preNode = itr;
            itr = itr.right;
            while(itr!=null){
                st.push(itr);
                itr = itr.left;
            }
        }
        if(mist != null){
            swap(preNode, mist);
        }
        return;
    }
    private void swap(TreeNode a, TreeNode b){
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
        return;
    }
}

