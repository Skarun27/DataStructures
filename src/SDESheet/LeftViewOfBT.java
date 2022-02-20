package SDESheet;

import SDESheet.BinaryTree.PreOrderTraversal;
import SDESheet.LinkedListI.ReverseLinkedList;

import java.util.ArrayList;

public class LeftViewOfBT {
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root, 0, list);
        return list;
    }

    void traverse(Node root, int level, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        if(level == list.size()) {
            list.add(root.val);
        }
        traverse(root.left, level+1, list);
        traverse(root.right, level+1, list);
    }

    //Definition for singly-linked list.
    private class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
