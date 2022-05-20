package Practice.Recursion;

public class ValidateBST {

    public static class Node {
        int val;
        Node left;
        Node right;
        public Node(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isValidBST(Node root) {
        return validate(root, null, null);
    }

    public static boolean validate(Node root, Integer low, Integer high) {
        if(root == null) return true;

        if(low != null && low >= root.val || high != null && high <= root.val)
            return false;

        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
    
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(1);
        Node node3 = new Node(6);
        Node node4 = new Node(3);
        Node node5 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(isValidBST(node1)); 
    }
}
