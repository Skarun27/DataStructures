package Practice.Heap;

import java.util.PriorityQueue;

public class FurthestBuildingToReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = heights.length;
        for(int i=0; i<n-1; i++) {
            
            if(heights[i] < heights[i+1]) {
                int height = heights[i+1] - heights[i];
                minHeap.offer(height);
                if(minHeap.size() > ladders) {
                    int minDiff = minHeap.poll();
                    if(bricks >= minDiff) {
                        bricks -= minDiff;
                    }
                    else return i;
                }
            }
        }
        return n-1;
    }
}
