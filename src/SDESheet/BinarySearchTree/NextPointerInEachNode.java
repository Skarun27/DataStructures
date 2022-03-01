package SDESheet.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerInEachNode {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new Node(1001));

        while(!queue.isEmpty()) {

            Node node = queue.remove();

            if(node.val != 1001) {
                if(queue.peek().val == 1001) {
                    node.next = null;
                }
                else
                    node.next = queue.peek();

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            else if(queue.size() > 0)
                queue.add(new Node(1001));
        }
        return root;
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
