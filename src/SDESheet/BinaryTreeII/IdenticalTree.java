package SDESheet.BinaryTreeII;

public class IdenticalTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag = true;
        flag = checkTree(p, q);
        return flag;
    }

    boolean checkTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;

        boolean left = checkTree(p.left, q.left);
        boolean right = checkTree(p.right, q.right);

        return p.val == q.val && left && right;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
