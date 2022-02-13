package SDESheet.StackAndQueueII;

import java.util.HashMap;

class LRUCache {
    DLinkedList head, tail;
    HashMap<Integer, DLinkedList> map = new HashMap<>();
    private int count;
    private int capacity;

    public LRUCache(int capacity) {

        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();

        head.post = tail;
        tail.pre = head;
    }

    static class DLinkedList {
        int key;
        int value;
        DLinkedList pre;
        DLinkedList post;
    }

    public void addNode(DLinkedList node) {

        DLinkedList temp = head.post;
        node.post = temp;
        node.pre = head;
        head.post = node;
        temp.pre = node;
    }

    public DLinkedList removeNode(DLinkedList node) {

        node.pre.post = node.post;
        node.post.pre = node.pre;
        return node;
    }

    public void moveToHead(DLinkedList node) {

        this.removeNode(node);
        this.addNode(node);
    }

    public DLinkedList popTail() {

        return this.removeNode(tail.pre);
    }

    public int get(int key) {

        if(!map.containsKey(key)) {
            return -1;
        }
        else {
            this.moveToHead(map.get(key));
            return map.get(key).value;
        }
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            DLinkedList node = map.get(key);
            node.value = value;
            this.moveToHead(node);
        }

        else {
            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.value = value;
            this.addNode(newNode);
            map.put(key, newNode);
            ++count;

            if(count > capacity) {
                DLinkedList node = this.popTail();
                map.remove(node.value);
                --count;
            }
        }
    }
}
