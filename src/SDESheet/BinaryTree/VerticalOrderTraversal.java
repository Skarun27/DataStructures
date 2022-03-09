package SDESheet.BinaryTree;

import java.util.*;

public class VerticalOrderTraversal {
    class Pair{

        TreeNode node;
        int row;
        int col;
        public Pair(TreeNode node, int rowNum, int colNum){
            this.node = node;
            this.row = rowNum;
            this.col = colNum;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        Map<Integer, TreeMap<Integer, PriorityQueue< Integer >>> map = new TreeMap<>();

        while(q.size() != 0) {
            Pair temp = q.remove();
            int row = temp.row;
            int col = temp.col;

            if(!map.containsKey(col)) {
                map.put(col, new TreeMap());
            }
            if(!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue());
            }
            map.get(col).get(row).add(temp.node.val);

            if(temp.node.left != null)
                q.add(new Pair(temp.node.left, row+1, col-1));
            if(temp.node.right != null)
                q.add(new Pair(temp.node.right, row+1, col+1));
        }

        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

     // Definition for a binary tree node.
      private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int val) { this.val = val; }
     }
}
