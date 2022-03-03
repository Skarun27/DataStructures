package SDESheet.BinarySearchTree;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer lowerBound, Integer upperBound) {
        if(root == null) return true;
        if(upperBound != null && root.val >= upperBound || lowerBound != null && root.val <= lowerBound)
            return false;
        return isValid(root.left, lowerBound, root.val) && isValid(root.right, root.val, upperBound);
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
