import java.util.*;

/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node pre = null;
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                Node n = queue.poll();
                if(n == null){
                    continue;
                }
                if(pre == null){
                    pre = n;
                }else{
                    pre.next = n;
                    pre = n;
                }
                queue.offer(n.left);
                queue.offer(n.right);
            }
            pre = null;
        }
        return root;
    }
}

