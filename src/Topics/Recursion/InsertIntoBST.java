package Topics.Recursion;

public class InsertIntoBST {

    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int num) {
        if(root == null) {
            Node node = new Node(num);
            return node;
        }

        if(num < root.data) {
            root.left = insert(root.left, num);
        }

        else {
            root.right = insert(root.right, num);
        }

        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(9);
        Node node6 = new Node(11);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;

        insert(node1, 8);
        System.out.println(node5.left.data);
    }
}