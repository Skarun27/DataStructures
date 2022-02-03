package SDESheet.LinkedListI;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode();
        ListNode head = list3;

        while(list1 != null && list2 != null) {

            if(list1.val > list2.val) {
                list3.next = new ListNode(list2.val);
                list3 = list3.next;
                list2 = list2.next;
            }
            else {
                list3.next = new ListNode(list1.val);
                list3 = list3.next;
                list1 = list1.next;
            }
        }
        if(list1 == null) {
            while(list2 != null) {
                list3.next = new ListNode(list2.val);
                list3 = list3.next;
                list2 = list2.next;
            }
        }
        else if(list2 == null) {
            while(list1 != null) {
                list3.next = new ListNode(list1.val);
                list3 = list3.next;
                list1 = list1.next;
            }
        }
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
