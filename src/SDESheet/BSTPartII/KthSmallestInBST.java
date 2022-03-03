package SDESheet.BSTPartII;

import java.util.Stack;

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack();
        while(true) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            TreeNode node = st.pop();
            if(--k == 0)
                return node.val;
            root = node.right;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
