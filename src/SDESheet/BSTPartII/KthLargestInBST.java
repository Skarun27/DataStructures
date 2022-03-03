package SDESheet.BSTPartII;

import java.util.Stack;

public class KthLargestInBST {
    public int kthLargest(Node root,int K)
    {
        //Your code here
        Stack<Node> st = new Stack<>();
        while(true) {
            while(root != null) {
                st.push(root);
                root = root.right;
            }
            Node node = st.pop();
            if(--K == 0) return node.val;
            root = node.left;
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
