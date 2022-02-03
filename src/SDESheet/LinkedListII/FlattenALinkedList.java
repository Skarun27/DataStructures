package SDESheet.LinkedListII;

public class FlattenALinkedList {
    Node mergeLists(Node a, Node b) {
        Node root = new Node(0);
        Node temp = root;

        while(a != null && b != null) {
            if(a.val < b.val) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if(a != null) temp.bottom = a;
        else temp.bottom = b;
        return root.bottom;
    }

    Node flatten(Node root)
    {
        // Your code here
        if(root == null || root.next == null) {
            return root;
        }
        root.next = flatten(root.next);
        root = mergeLists(root, root.next);
        return root;
    }

    /**
     * Definition for singly-linked list.
     */
    private class Node {
        int val;
        Node next;
        Node bottom;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }
}
