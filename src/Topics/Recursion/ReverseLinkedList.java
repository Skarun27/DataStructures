package Topics.Recursion;
import java.util.LinkedList;

public class ReverseLinkedList {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node node, Node head) {
        if(node == null || node.next == null) {
            return node;
        }

        head = reverse(node.next, head);
        node.next.next = node;
        node.next = null;
        return head;
    }

    public static void main(String[] args) {

        Node node1 = new Node(-1);
        Node node2 = new Node(0);
        Node node3 = new Node(2);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(13);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node head = node1;

        head = reverse(node1, head);

        while(head != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
    }
}
