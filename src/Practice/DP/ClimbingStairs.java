package Practice.DP;

import java.util.HashMap;

public class ClimbingStairs {

    private static HashMap<Integer, Integer> map = new HashMap<>();

    // Memoization : top-down approach
    public static int climbingStairs(int n) {
        if(n <= 2) {
            return n;
        }

        if(!map.containsKey(n))
            map.put(n, climbingStairs(n-1) + climbingStairs(n-2));

        return map.get(n);
    }

    // Tabular : bottom-up approach
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        
        // An array that represents the answer to the problem for a given state
        int[] dp = new int[n + 1]; 
        dp[1] = 1; // Base cases
        dp[2] = 2; // Base cases
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Recurrence relation
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbingStairs(30));
    }
}
