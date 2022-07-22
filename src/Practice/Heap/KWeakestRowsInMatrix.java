package Practice.Heap;
import java.util.*;

public class KWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        HashMap<Integer, Integer> soldierCount = new HashMap<>();
        
        for(int i=0; i<mat.length; i++) {
            int count = 0;
            
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0) break;
                count++;
            }
            soldierCount.put(i, count);
        }
        
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> {
                if(soldierCount.get(n1) == soldierCount.get(n2)) return n2 - n1;
                else return soldierCount.get(n2) - soldierCount.get(n1);
            });
        
        for(int i=0; i<mat.length; i++) {
            heap.offer(i);
            if(heap.size() > k)
                heap.poll();
        }
        
        int[] weakestRows = new int[k];
        for(int i=k-1; i>=0; i--) {
            weakestRows[i] = heap.poll();
        }
        
        return weakestRows;
    }
}
