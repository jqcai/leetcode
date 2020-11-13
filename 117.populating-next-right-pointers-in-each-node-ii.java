/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
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
        Node leftMost = root;
        while (leftMost != null) {
            Node pre = null;
            Node nextLeft = null;
            Node cur = leftMost;
            while(cur != null) {
                if(cur.left != null) {
                    if(pre == null) {
                        pre = cur.left;
                        nextLeft = pre;
                    }else{
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if(cur.right != null) {
                    if(pre == null) {
                        pre = cur.right;
                        nextLeft = pre;
                    }else{
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            leftMost = nextLeft;
        }
        return root;
    }
}
