package SDESheet.BSTPartII;

import java.util.HashSet;

public class TwoSumInBST {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findSum(root, k, set);
    }

    public boolean findSum(TreeNode root, int sum, HashSet<Integer> set) {
        if(root == null) return false;
        if(set.contains(sum - root.val)) return true;
        set.add(root.val);
        return (findSum(root.left, sum, set) || findSum(root.right, sum, set));
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
