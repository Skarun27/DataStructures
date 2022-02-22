package SDESheet.BinaryTreeII;

public class DiameterOfBT {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        diameter(root);
        return diameter;
    }

    public int diameter(TreeNode node) {
        if(node == null)
            return 0;

        int leftDepth = diameter(node.left);
        int rightDepth = diameter(node.right);
        diameter = Math.max(diameter, leftDepth+rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
    }
}
