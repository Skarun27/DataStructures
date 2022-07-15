package Practice.Graphs.DFS;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxCount = Math.max(maxCount, dfs(i, j, grid));
                    System.out.println(maxCount);
                }
            }
        }
        return maxCount;
    }
    
    public int dfs(int row, int col, int[][] grid) {
        
        int[] rows = {1,-1,0,0};
        int[] cols = {0,0,1,-1};
        int count = 0;
        grid[row][col] = 0;
        for(int i=0; i<rows.length; i++) {
            int newRow = row+rows[i];
            int newCol = col+cols[i];
            if(isValid(newRow, newCol, grid)) {
                count += dfs(newRow, newCol, grid);
            }    
        }
        return count+1;
    }
    
    public boolean isValid(int row, int col, int[][] grid) {
        
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            return grid[row][col] == 1;
        }
        return false;
    }
}