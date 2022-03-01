package SDESheet.BinarySearchTree;

public class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        else
            return root;
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
