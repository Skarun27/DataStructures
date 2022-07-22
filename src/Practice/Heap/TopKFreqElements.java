package Practice.Heap;
import java.util.*;

public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i],0) + 1);
        }
        
        Queue<Integer> pq = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));
        
        for(int n: count.keySet()) {
            pq.add(n);
            if(pq.size() > k) pq.poll();
        }
        
        int[] freqEle = new int[k];
        for(int i=k-1; i>=0; i--) {
            freqEle[i] = pq.poll();
        }
        
        return freqEle;
    }
}
