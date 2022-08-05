package Practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {
    
    PriorityQueue<Double> lo;
    PriorityQueue<Double> hi;
    
    public MedianFromDataStream() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lo.add((double)num);
        hi.add((double)lo.poll());
        if(lo.size() < hi.size())
            lo.add(hi.poll());
    }
    
    public double findMedian() {
        
        int size = lo.size() + hi.size();
        double median = size % 2 == 1 ? lo.peek() : (lo.peek() + hi.peek()) / 2;
        return median;
    }
}
