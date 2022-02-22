package SDESheet.BinaryTreeII;

public class MaxDepthOfBT {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
    }
}
