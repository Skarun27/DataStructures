package Practice.DP;

import java.util.HashMap;

public class DeleteAndEarn {
    
    private HashMap<Integer, Integer> memo = new HashMap<>();
    private HashMap<Integer, Integer> points = new HashMap<>();
    
    
    // Imp point to note is, the order of deletion doesn't matter. Therefore we can store nums in 
    // other data structure such as Map, and delete as per our convenience.
    public int deleteAndEarn(int[] nums) {
        
        int maxNum = 0;
        
        for(int num: nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNum = Math.max(num, maxNum);
        }
        
        return maxPoints(maxNum);
    }
                  
    public int maxPoints(int num) {
        
        if(num == 0)
            return 0;
        
        if(num == 1)
            return points.getOrDefault(1,0);
        
        if(memo.containsKey(num)) {
            return memo.get(num);
        }
        
        int gain = points.getOrDefault(num, 0);
        memo.put(num, Math.max(maxPoints(num-1), maxPoints(num-2) + gain));
        return memo.get(num);
    }
}
