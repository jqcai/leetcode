import java.util.*;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> hm = new HashMap<>();
        Set<Node> traversed = new HashSet<>();
        Stack<Node> st = new Stack<>();
        st.push(node);
        while(!st.isEmpty()){
            Node n = st.pop();
            // System.out.println(n.val);
            if(traversed.contains(n)){
                continue;
            }
            Node nw = hm.getOrDefault(n, new Node(n.val, new LinkedList<Node>()));            
            for(Node t:n.neighbors){
                Node tw = hm.getOrDefault(t, new Node(t.val, new LinkedList<Node>()));
                nw.neighbors.add(tw);
                hm.put(t, tw);
                st.push(t);
            }
            traversed.add(n);
            hm.put(n, nw);
        }
        return hm.get(node);
    }
}

