package SDESheet.BinaryTreeII;

public class BalancedBT {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        height(root);
        return flag;
    }

    public int height(TreeNode node) {
        if(node == null)
            return 0;

        int left = 0;
        int right = 0;

        if(flag) {
            left = height(node.left);
            right = height(node.right);
            if(Math.abs(left - right) > 1)
                flag = false;
        }
        return Math.max(left, right) +1;
    }

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
    }
}
