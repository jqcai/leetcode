/*
 * @lc app=leetcode id=545 lang=java
 *
 * [545] Boundary of Binary Tree
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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        if(root == null){
            return ans;
        }
        // queue.offer(root);
        TreeNode traverse = root;
        if(root.left != null){
            while(traverse != null){
                if(traverse.left == null && traverse.right == null){
                    break;
                }else if(traverse.left != null){
                    ans.add(traverse.val);
                    traverse = traverse.left;
                }else{
                    ans.add(traverse.val);
                    traverse = traverse.right;
                }
            }
            queue.offer(root.left);
        }else{
            ans.add(root.val);
        }
        if(root.right != null){
            traverse = root.right;
            while(traverse != null){
                if(traverse.left == null && traverse.right == null){
                    break;
                }else if(traverse.right != null){
                    stack.push(traverse.val);
                    traverse = traverse.right;
                }else{
                    stack.push(traverse.val);
                    traverse = traverse.left;
                }
            }
            queue.offer(root.right);
        }
        while(queue.size() > 0){
            int size = queue.size();
            boolean allLeaf = true;
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                if(tmp.left == null && tmp.right == null){
                    queue.offer(tmp);
                }
                if(tmp.left != null){
                    allLeaf = false;
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    allLeaf = false;
                    queue.offer(tmp.right);
                }
            }
            if(allLeaf){
                while(!queue.isEmpty()){
                    ans.add(queue.poll().val);
                }
                while(!stack.isEmpty()){
                    ans.add(stack.pop());
                }
                break;
            }
        }
        return ans;
    }
}

