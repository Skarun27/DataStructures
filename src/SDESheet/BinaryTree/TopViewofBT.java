package SDESheet.BinaryTree;

import java.util.*;

public class TopViewofBT {
    static class Pair{
        Node node;
        int hd;
        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(root, 0));

        while(queue.size() != 0) {

            Pair temp = queue.remove();
            if(!map.containsKey(temp.hd))
                map.put(temp.hd, temp.node.data);
            int hd = temp.hd;

            if(temp.node.left != null) {
                queue.add(new Pair(temp.node.left, hd-1));
            }

            if(temp.node.right != null) {
                queue.add(new Pair(temp.node.right, hd+1));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    private class Node {
        int data;
        Node left;
        Node right;
        Node() {}
        Node(int val) {
            this.data = val;
        }
    }
}
