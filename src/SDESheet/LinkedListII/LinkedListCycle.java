package SDESheet.LinkedListII;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode headA = head;
        ListNode headB = head.next;
        while(headB != headA) {
            if(headB == null || headB.next == null)
                return false;
            headA = headA.next;
            headB = headB.next.next;
        }
        return true;
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
