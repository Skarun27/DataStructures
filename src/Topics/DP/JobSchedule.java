package Practice.DP;

import java.util.Arrays;

public class JobSchedule {
    
    int[] jobDifficulty;
    int[] hardestJobDifficulty;
    int[][] memo;
    int d;
    int n;
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        this.n = jobDifficulty.length;
        this.d = d;
        if(n < d) return -1;
        
        this.jobDifficulty = jobDifficulty;
        this.hardestJobDifficulty = new int[n];
        
        int hardest = 0;
        for(int i=n-1; i>=0; i--) {
            hardest = Math.max(hardest, jobDifficulty[i]);
            hardestJobDifficulty[i] = hardest;
        }
        
        memo = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return dp(0, 1);
    }
    
    public int dp(int i, int day) {
        
        if(d == day)
            return hardestJobDifficulty[i];
        
        if(memo[i][day] == -1) 
        {
            int best = Integer.MAX_VALUE;
            int hardest = 0;

            for(int j=i; j<n-(d-day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                best = Math.min(best, hardest + dp(j+1, day+1));    
            }    
            memo[i][day] = best;
        }
        
        return memo[i][day];
    }
}
