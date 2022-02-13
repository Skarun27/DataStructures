package SDESheet.StackAndQueueII;

import java.util.HashMap;

class LFUCache {
    HashMap<Integer, DLinkedList> map;
    HashMap<Integer, DoubleLinkedList> frequencyMap;
    private int count;
    private int capacity;
    private int minFrequency;

    public LFUCache(int capacity) {

        this.count = 0;
        this.capacity = capacity;
        this.minFrequency = 0;

        this.map = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    private static class DLinkedList {
        int key;
        int value;
        int frequency;
        DLinkedList pre;
        DLinkedList post;

        public DLinkedList(int key, int val) {
            this.key = key;
            this.value = val;
            this.frequency = 1;
        }
    }

    public int get(int key) {

        if(!map.containsKey(key)) {
            return -1;
        }
        updateNode(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            DLinkedList node = map.get(key);
            node.value = value;
            updateNode(node);
        }

        else {
            ++count;
            if(count > capacity) {
                DoubleLinkedList nodeList = frequencyMap.get(minFrequency);
                map.remove(nodeList.tail.pre.key);
                nodeList.removeNode(nodeList.tail.pre);
                --count;
            }
            minFrequency = 1;
            DLinkedList newNode = new DLinkedList(key, value);
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            map.put(key, newNode);
        }
    }

    public void updateNode(DLinkedList curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        curNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }

    class DoubleLinkedList {
        int listSize;
        DLinkedList head;
        DLinkedList tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLinkedList(0, 0);
            this.tail = new DLinkedList(0, 0);
            head.post = tail;
            tail.pre = head;
        }

        /** add new node into head of list and increase list size by 1 **/
        public void addNode(DLinkedList curNode) {
            DLinkedList nextNode = head.post;
            curNode.post = nextNode;
            curNode.pre = head;
            head.post = curNode;
            nextNode.pre = curNode;
            listSize++;
        }

        /** remove input node and decrease list size by 1**/
        public void removeNode(DLinkedList curNode) {
            DLinkedList prevNode = curNode.pre;
            DLinkedList nextNode = curNode.post;
            prevNode.post = nextNode;
            nextNode.pre = prevNode;
            listSize--;
        }

    }
}
