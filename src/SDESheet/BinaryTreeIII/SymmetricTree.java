package SDESheet.BinaryTreeIII;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        boolean isSymmetric = symmetricRec(root.left, root.right, true);
        return isSymmetric;
    }

    boolean symmetricRec(TreeNode leftRoot, TreeNode rightRoot, boolean isSymmetric) {
        if(leftRoot != null && rightRoot != null && leftRoot.val != rightRoot.val) return false;
        if(leftRoot != null && rightRoot == null ||
                leftRoot == null && rightRoot != null) return false;
        if(isSymmetric && leftRoot != null && rightRoot != null) {
            isSymmetric = symmetricRec(leftRoot.left,rightRoot.right, isSymmetric) &&
                    symmetricRec(leftRoot.right,rightRoot.left, isSymmetric);
        }
        return isSymmetric;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
