package Google.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        leaves(root, result);
        return result;
    }
    
    public int leaves(TreeNode root, List<List<Integer>> result) {
        
        if(root == null) 
            return -1;
        
        int leftHeight = leaves(root.left, result);
        int rightHeight = leaves(root.right, result);
        
        int height = Math.max(leftHeight, rightHeight) + 1;
        
        if(height == result.size()) {
            result.add(new ArrayList<>());
        }
        
        result.get(height).add(root.val);
        
        return height;
    }
}


//   Definition for a binary tree node.
class TreeNode {
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