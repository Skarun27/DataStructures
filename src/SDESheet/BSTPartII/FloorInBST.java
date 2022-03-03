package SDESheet.BSTPartII;

import SDESheet.BinarySearchTree.ValidateBST;

public class FloorInBST {
    static int pre = -1;
    public static int floorInBST(TreeNode root, int X) {
        //    Write your code here.
        while(root != null) {
            if(root.data <= X) {
                pre = root.data;
                root = root.right;
            }
            else
                root = root.left;
        }
        return pre;
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.data = val;
        }
    }
}
