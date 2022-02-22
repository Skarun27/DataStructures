package SDESheet.BinaryTreeII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            list.add(new ArrayList());
            int idx = size-1;

            for(int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(level % 2 == 0)
                    list.get(list.size()-1).add(node.val);
                else
                    list.get(list.size()-1).add(0, node.val);
            }
            level++;
        }
        return list;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
