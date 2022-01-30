public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            newNode.random = curr.random;
            curr = newNode.next;
        }
        Node newHead = head.next;
        curr = head.next;
        while (curr != null) {
            if (curr.random != null) {
                curr.random = curr.random.next;
            }
            curr = curr.next;
            if (curr != null) {
                curr = curr.next;
            }
        }
        curr = head;
        Node next = curr.next;
        while (curr != null) {
            next = curr.next;
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
            curr = next;
        }
        return newHead;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
