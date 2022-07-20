package Practice.Heap;

public class MaxHeap {
    
    int[] maxHeap;
    int realSize = 0;
    int heapSize;

    public MaxHeap(int heapSize) {
        this.maxHeap = new int[heapSize+1];
        this.heapSize = heapSize;
        maxHeap[0] = 0;
    }

    public void add(int value) {
        
        realSize++;
        if(realSize > heapSize) {
            System.out.println("Max capacity of heap reached!");
            realSize--;
        }

        maxHeap[realSize] = value;
        int index = realSize;
        int parent = index/2;

        while(maxHeap[parent] < maxHeap[index] && index > 1) {
            int temp = maxHeap[parent];
            maxHeap[parent] = maxHeap[index];
            maxHeap[index] = temp;
            index = parent;
            parent = index/2;
        }
    }

    public int pop() {
        
        if(realSize < 1) {
            System.out.println("No elements present!");
        }
        int removeElement = maxHeap[1];
        maxHeap[1] = maxHeap[realSize];
        realSize--;
        int index = 1;

        while(index <= realSize/2) {
            int left = index * 2;
            int right = (index * 2) + 1;

            if(maxHeap[index] < maxHeap[left] || maxHeap[index] < maxHeap[right]) {

                if(maxHeap[left] > maxHeap[right]) {
                    int temp = maxHeap[left];
                    maxHeap[left] = maxHeap[index];
                    maxHeap[index] = temp;
                }

                else {
                    int temp = maxHeap[right];
                    maxHeap[right] = maxHeap[index];
                    maxHeap[index] = temp;
                }
            }
            else break;
        }
        return removeElement;
    }

    public int peek() {
        return maxHeap[1];
    }

    public String toString() {
        if (realSize == 0) {
            return "No element!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 1; i <= realSize; i++) {
                sb.append(maxHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Test case
        MaxHeap maxHeap = new MaxHeap(3);
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(2);
        // [1,3,2]
        System.out.println(maxHeap.toString());
        // 1
        System.out.println(maxHeap.peek());
        // 1
        System.out.println(maxHeap.pop());
        // [2, 3]
        System.out.println(maxHeap.toString());
        maxHeap.add(4);
        // Add too many elements
        maxHeap.add(5);
        // [2,3,4]
        System.out.println(maxHeap.toString());
        maxHeap.add(7);
        System.out.println(maxHeap.toString());
    }
}
