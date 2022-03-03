package SDESheet.BinarySearchTree;

public class ConstructBSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return preOrder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode preOrder(int[] preorder, int bound, int[] nums) {
        if(nums[0] == preorder.length || preorder[nums[0]] > bound) return null;
        TreeNode node = new TreeNode(preorder[nums[0]++]);
        node.left = preOrder(preorder, node.val, nums);
        node.right = preOrder(preorder, bound, nums);
        return node;
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
