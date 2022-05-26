package Practice.DP;

import java.util.HashMap;

public class MinMostClimbingStairs {
    
    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static int minCostClimbingStairs(int[] cost, int ind) {

        if(ind == 1)
            return 0;

        if(ind == 2)
            return Math.min(cost[0] , cost[1]);

        if(!memo.containsKey(ind))
            memo.put(ind, Math.min(minCostClimbingStairs(cost, ind-1) + cost[ind-1], 
            minCostClimbingStairs(cost, ind-2) + cost[ind-2]));

        return memo.get(ind);
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        // int[] cost = {10, 15, 20};

        System.out.println(minCostClimbingStairs(cost, cost.length));
    }
}
