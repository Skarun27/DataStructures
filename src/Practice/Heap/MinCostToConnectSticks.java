package Practice.Heap;

import java.util.PriorityQueue;

public class MinCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        
        if(sticks.length == 1) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int stick: sticks) {
            minHeap.offer(stick);
        }
        
        int minCost = 0;
        while(minHeap.size() > 1) {
            int min = minHeap.poll();
            int secondMin = minHeap.poll();
            
            int cost = min + secondMin;
            minCost += cost;
            
            minHeap.offer(cost);
        }
        
        return minCost;
    }
}
