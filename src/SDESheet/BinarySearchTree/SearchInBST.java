package SDESheet.BinarySearchTree;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
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
