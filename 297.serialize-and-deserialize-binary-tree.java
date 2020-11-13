import java.util.*;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn == null) {
                sb.append('N');
            } else {
                sb.append(tn.val);
                queue.offer(tn.left);
                queue.offer(tn.right);
            }
            sb.append(',');
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("N,")) {
            return null;
        }
        // return null;
        int pos = data.indexOf(",");
        // if (pos == -1) {
        //     throw new Exception("input not valid");
        // }
        int rootValue = Integer.parseInt(data.substring(0, pos));
        TreeNode root = new TreeNode(rootValue);
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Boolean> flag = new LinkedList<>();
        queue.offer(root);
        flag.offerLast(false);
        StringBuilder sb = new StringBuilder(data.substring(pos + 1));
        while (sb.length() > 0) {
            // System.out.println(sb.toString());
            int nextDivide = sb.indexOf(",");
            String treeValue = sb.substring(0, nextDivide);
            // System.out.println(treeValue);
            if(treeValue.equals("N")){
                // System.out.println(1);
                if(flag.pollFirst()){
                    queue.poll();
                }else{
                    flag.offerFirst(true);
                }
            }else{
                TreeNode newNode = new TreeNode(Integer.parseInt(treeValue));
                queue.offer(newNode);
                flag.offer(false);
                if(flag.pollFirst()){
                    queue.poll().right = newNode;
                }else{
                    flag.offerFirst(true);
                    queue.peek().left = newNode;
                }
            }
            sb.delete(0, nextDivide + 1);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
