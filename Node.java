// public class Node {
//     public int val;
//     public Node prev;
//     public Node next;
//     public Node child;

//     public Node() {
//     }

//     public Node(int _val, Node _prev, Node _next, Node _child) {
//         val = _val;
//         prev = _prev;
//         next = _next;
//         child = _child;
//     }
// };
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
    public static void main(String[] args){
        System.out.println("Hello World");
    }
};