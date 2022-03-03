package SDESheet.BinarySearchTree;

public class PredecessorAndSuccessor {
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        // add your code here
        if(root == null) return;
        Node node = root;
        while(node != null) {
            if(node.data > key) {
                s.succ = node;
                node = node.left;
            }
            else
                node = node.right;
        }

        node = root;
        while(node != null) {
            if(node.data < key) {
                p.pre = node;
                node = node.right;
            }
            else
                node = node.left;
        }
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
}
