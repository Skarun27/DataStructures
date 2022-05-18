package Practice.Recursion;

public class PrintLeafNodes {

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

    public static void print(Node root) {

        if(root == null)
            return;

        if(root.left == null && root.right == null) {
            System.out.println(root.data);
            return;
        }    

        print(root.left);
        print(root.right);
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

        print(node1);
        System.out.println();
    }
}