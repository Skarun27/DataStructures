package Practice.Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] paths = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        if(grid[0][0] == 1) return -1;
        if(grid.length == 1 && grid[0][0] == 0) return 1;
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int node=0; node<size; node++) {
                
                int[] temp = queue.poll();
                int row = temp[0];
                int col = temp[1];
                
                for(int i=0; i<paths.length; i++) {
                    int newRow = row + paths[i][0];
                    int newCol = col + paths[i][1];
                    if(validPath(newRow, newCol, grid)) {
                        if(newRow == grid.length-1 && newCol == grid.length-1) return count;
                        queue.add(new int[]{newRow, newCol});
                        grid[newRow][newCol] = count;
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean validPath(int row, int col, int[][] grid) {
        if(row >= grid.length || col >= grid.length)
            return false;
        if(row < 0 || col < 0)
            return false;
        if(grid[row][col] != 0)
            return false;
        return true;
    }
}
