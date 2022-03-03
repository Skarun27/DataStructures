package SDESheet.BSTPartII;

public class CeilInBST {
    static int ceil = -1;
    public  static int findCeil(TreeNode node, int x) {

        // Write your code here
        while(node != null) {
            if(node.data >= x) {
                ceil = node.data;
                node = node.left;
            }
            else
                node = node.right;
        }
        return ceil;
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
