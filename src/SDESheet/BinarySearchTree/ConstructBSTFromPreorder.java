package SDESheet.BinarySearchTree;

public class ConstructBSTFromPreorder {
    public TreeNode sortedArrayToBST(int[] nums) {
        return preOrder(0, nums.length - 1, nums);
    }

    public TreeNode preOrder(int left, int right, int[] nums) {
        if(left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = preOrder(left, mid-1, nums);
        root.right = preOrder(mid+1, right, nums);
        return root;
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
