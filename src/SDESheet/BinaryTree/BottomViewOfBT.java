package SDESheet.BinaryTree;

import java.util.*;

public class BottomViewOfBT {
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(root);
        root.hd = 0;

        while(queue.size() != 0) {

            Node temp = queue.remove();
            map.put(temp.hd, temp.val);
            int hd = temp.hd;

            if(temp.left != null) {
                queue.add(temp.left);
                temp.left.hd = hd-1;
            }

            if(temp.right != null) {
                queue.add(temp.right);
                temp.right.hd = hd+1;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    //Definition for singly-linked list.
    private class Node {
        int val;
        int hd;
        Node left;
        Node right;
        Node() {}
        Node(int val) {
            this.val = val;
            this.hd = Integer.MAX_VALUE;
        }
    }
}
