package SDESheet.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recursive(root, list);
        return list;
    }

    public void recursive(TreeNode root, List<Integer> list) {
        if(root != null) {
            list.add(root.val);
            recursive(root.left, list);
            recursive(root.right, list);
        }
    }

    //Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
