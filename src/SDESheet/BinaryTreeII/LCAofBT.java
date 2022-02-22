package SDESheet.BinaryTreeII;

public class LCAofBT {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        isAncestor(root, p, q);
        return this.ans;
    }

    public boolean isAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) {
            return false;
        }

        int left = isAncestor(root.left, p, q) ? 1 : 0;

        int right = isAncestor(root.right, p, q) ? 1 : 0;

        int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;

        if((mid + left + right) >= 2)
            this.ans = root;

        return (mid + left + right > 0);
    }

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
    }
}
