package LeetcodeDailyProblems.August;

import java.util.LinkedList;

public class MyCalendarI {
    LinkedList<Node> list;
    Node head;
    public MyCalendarI() {
        list = new LinkedList<>();    
        head = new Node(0,0);
    }
    
    public boolean book(int start, int end) {
        
        if(head.next == null) {
            Node newNode = new Node(start, end);
            head.next = newNode;
            return true;
        }
        
        Node currNode = head.next;
        
        if(head.next.start >= end) {
            Node newNode = new Node(start, end);
            newNode.next = currNode;
            head.next = newNode;
            return true;
        }
        
        while(currNode != null && currNode.next != null) {
            
            if(start >= currNode.end && end <= currNode.next.start) {
                Node newNode = new Node(start, end);
                Node temp = currNode.next;
                currNode.next = newNode;
                newNode.next = temp;
                return true;
            }
            else if(start >= currNode.start && end <= currNode.next.end)
                return false;
        
            else currNode = currNode.next;
        }
        
        if(currNode != null && start >= currNode.end) {
            Node newNode = new Node(start, end);
            currNode.next = newNode;
            return true;
        }
        
        return false;
    }
}

class Node {
    int start;
    int end;
    Node next;
    
    public Node(int start, int end) {
        this.start = start;
        this.end = end;
        this.next = null;
    }
}
