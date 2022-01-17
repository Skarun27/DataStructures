import java.util.HashMap;

class LRUCache {

    class DLinkedList {
        int key;
        int val;
        DLinkedList pre;
        DLinkedList post;
    }

    private HashMap<Integer, DLinkedList> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedList head, tail;

    public void addNode(DLinkedList node) {
        node.pre = head;
        node.post = head.post;

        head.post = node;
        node.post.pre = node;
    }

    public void removeNode(DLinkedList node) {
        DLinkedList preNode = node.pre;
        DLinkedList postNode = node.post;

        preNode.post = postNode;
        postNode.pre = preNode;
    }

    public void moveToHead(DLinkedList node) {
        removeNode(node);
        addNode(node);
    }

    public DLinkedList popTail() {
        DLinkedList temp = tail.pre;
        removeNode(temp);
        return temp;
    }

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;

        DLinkedList head = new DLinkedList();
        DLinkedList tail = new DLinkedList();

        head.pre = null;
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedList node = cache.get(key);
        if(node == null){
            return -1;
        }
        this.moveToHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        DLinkedList node = cache.get(key);

        if(node == null){

            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.val = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                DLinkedList tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }
        else{
            // update the value.
            node.val = value;
            this.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */