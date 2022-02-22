package SDESheet.BinaryTreeII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        q.add(root);

        while(!q.isEmpty()) {
            list.add(new ArrayList<Integer>());
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.remove();
                list.get(list.size()-1).add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
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
