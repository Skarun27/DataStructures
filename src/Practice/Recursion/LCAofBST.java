package Practice.Recursion;

public class LCAofBST {

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

    public static Node lcaOfBST(Node root, int num1, int num2) {
        // if(num1 > root.data && num2 < root.data) {
        //     return root;
        // }

        // if(num1 < root.data && num2 > root.data) {
        //     return root;
        // }

        // if(root.data == num1 || root.data == num2) 
        //     return root;

        if(num1 < root.data && num2 < root.data)
            return lcaOfBST(root.left, num1, num2);

        else if(num1 > root.data && num2 > root.data)
            return lcaOfBST(root.right, num1, num2);

        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(9);
        Node node6 = new Node(11);
        Node node7 = new Node(12);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        node6.right = node7;

        System.out.println(lcaOfBST(node1, 10, 12).data);
        // System.out.println(node5.left.data);
    }
}