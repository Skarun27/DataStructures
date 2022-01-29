package EasyProblems;

public class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        ListNode tempNode = node.next;
        node.val = node.next.val;
        node.next = tempNode.next;
        tempNode.next = null;
    }

    /**
     * Definition for singly-linked list.
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
