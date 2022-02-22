package SDESheet.BinaryTreeII;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalOfBT {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List < Integer > ans = new ArrayList< Integer >();
        if (isLeaf(root) == false) ans.add(root.val);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    static void addLeftBoundary(TreeNode root, List < Integer > res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.val);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    static void addRightBoundary(TreeNode root, List < Integer > res) {
        TreeNode cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > ();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.val);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    static void addLeaves(TreeNode root, List < Integer > res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
