import java.util.Stack;

/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Stack<Node> st = new Stack<>();
        st.push(head);
        Node dummy = new Node(0, null, null, null);
        Node pre = dummy;
        while (!st.isEmpty()) {
            Node tmp = st.pop();
            if (tmp == null) {
                continue;
            }
            pre.next = tmp;
            tmp.prev = pre;
            pre = pre.next;
            st.push(pre.next);
            st.push(pre.child);
            pre.next = null;
            pre.child = null;
        }
        Node ans = dummy.next;
        if (ans != null) {
            ans.prev = null;
        }
        return ans;
    }
}
