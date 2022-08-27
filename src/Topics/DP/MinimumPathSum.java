package Topics.DP;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        
        dp[0][0] = grid[0][0];
        
        for(int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        for(int i=1; i<n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        
        for(int col = 1; col < m; ++col) {
            for(int row = 1; row < n; ++row) {
                dp[col][row] = grid[col][row] + Math.min(dp[col-1][row] , dp[col][row-1]);
            }
        }
        
        return dp[m-1][n-1];
    }
}
