package SDESheet.Graphs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == '1') {
                    dfsMarking(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    public void dfsMarking(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j>=grid[0].length || j<0 || grid[i][j] != '1')
            return;
        grid[i][j] = 0;
        dfsMarking(grid, i-1, j);
        dfsMarking(grid, i+1, j);
        dfsMarking(grid, i, j-1);
        dfsMarking(grid, i, j+1);
    }
}
