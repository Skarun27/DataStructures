package Topics.Heap;
import java.util.*;

public class KthLargestEleInStream {
    int k;
    PriorityQueue<Integer> heap;
    
    public KthLargestEleInStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        
        for(int num: nums) {
            heap.offer(num);
            if(heap.size() > k)
                heap.poll();
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size() > k)
            heap.poll();
        return heap.peek();
    }
}
