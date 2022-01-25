package EasyProblems;

public class LinkedListCycle {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
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
}
