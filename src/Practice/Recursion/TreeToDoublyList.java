package Practice.Recursion;

public class TreeToDoublyList {

    static class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public static Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        Node prev = dummy;
        prev = inorder(root, prev);
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right; 
    }
    
    private static Node inorder(Node node, Node prev) {
        if (node == null) return prev;
        prev = inorder(node.left, prev);
        prev.right = node;
        node.left = prev;
        prev = inorder(node.right, node);
        return prev;
    }

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        Node node5 = new Node(5);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
    
        treeToDoublyList(node1);
    }
}
