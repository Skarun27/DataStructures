package SDESheet.LinkedListI;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode root = new ListNode();
        ListNode head = root;
        ListNode first = l1;
        ListNode second = l2;

        while(first != null || second != null) {

            int val1 = (first != null) ? first.val : 0;
            int val2 = (second != null) ? second.val : 0;

            int sum = carry + val1 + val2;
            carry = sum / 10;

            root.next = new ListNode(sum % 10);
            root = root.next;

            if(first != null)
                first = first.next;
            if(second != null)
                second = second.next;
        }
        if(carry>0)
            root.next = new ListNode(carry);
        return head.next;
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
