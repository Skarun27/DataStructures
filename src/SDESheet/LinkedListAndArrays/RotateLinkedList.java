package SDESheet.LinkedListAndArrays;

import SDESheet.LinkedListII.PalindromeLinkedList;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode slow = node;
        ListNode fast = node;
        int len = 0;
        while(fast.next != null) {
            fast = fast.next;
            len++;
        }
        fast.next = head;
        k = k%len;
        for(int i=0; i<len-k; i++) {
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        head = temp;
        return head;
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
