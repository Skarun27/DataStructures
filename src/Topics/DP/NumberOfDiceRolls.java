package Topics.DP;

public class NumberOfDiceRolls {
    public int numRollsToTarget(int n, int k, int target) {
        
        if(n == 0) return 0;
        if(target == 0) return 0;
        
        int[][] dp = new int[n][target];
        
        for(int i=0; i<target; i++) {
            if(i >= k)
                dp[0][i] = 0;
            else
                dp[0][i] = 1;
        }
        
        for(int i=1; i<n; i++) {
            for(int j=i; j<target; j++) {
                
                if(i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                
                else {
                    int sum = 0;
                    for(int m=1; m<=k && m<=j; m++) {
                        sum = (sum + dp[i-1][j-m]) % 1000000007;
                    }
                    dp[i][j] = sum;
                }
            }
        }
        return dp[n-1][target-1];
    }
}
