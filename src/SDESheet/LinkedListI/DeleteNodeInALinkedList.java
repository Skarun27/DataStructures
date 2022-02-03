package SDESheet.LinkedListI;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode tempNode = node.next;
        node.val = node.next.val;
        node.next = tempNode.next;
        tempNode.next = null;
    }

    /**
     * Definition for singly-linked list.
     */
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
