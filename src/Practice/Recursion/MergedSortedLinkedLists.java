package Practice.Recursion;

public class MergedSortedLinkedLists {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node merge(Node node1, Node node2) {

        if(node1 == null) return node2;
        if(node2 == null) return node1;

        if(node1.data < node2.data) {
            node1.next = merge(node1.next, node2);
            return node1;
        }
        else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
    
    public static void main(String[] args) {
        
        Node node1 = new Node(-1);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(13);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node node5 = new Node(0);
        Node node6 = new Node(6);
        Node node7 = new Node(8);
        
        node5.next = node6;
        node6.next = node7;

        Node head1 = node1;
        Node head2 = node5;

        Node head = merge(node1, node5);

        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
