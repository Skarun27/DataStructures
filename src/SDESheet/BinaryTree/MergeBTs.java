package SDESheet.BinaryTree;

public class MergeBTs {
    private class Node {
        int val;
        int hd;
        Node left;
        Node right;
        Node() {}
        Node(int val) {
            this.val = val;
            this.hd = Integer.MAX_VALUE;
        }
    }

    public Node merge(Node root1, Node root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        root1.val += root2.val;
        root1.left = merge(root1.left, root2.left);
        root1.right = merge(root1.right, root2.right);
        return root1;
    }
}
