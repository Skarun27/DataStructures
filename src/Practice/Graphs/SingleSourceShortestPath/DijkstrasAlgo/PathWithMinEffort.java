package Practice.Graphs.SingleSourceShortestPath.DijkstrasAlgo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0,1}};
        boolean[][] visited = new boolean[row][col];
        
        int[][] differenceMatrix = new int[row][col];
        for(int[] rows: differenceMatrix) 
            Arrays.fill(rows, Integer.MAX_VALUE);
        
        differenceMatrix[0][0] = 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.difference - b.difference);
        pq.add(new Cell(0, 0, differenceMatrix[0][0]));

        while(!pq.isEmpty()) {
            Cell curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int cost = curr.difference;
            visited[x][y] = true;
            if(x == row-1 && y == col-1) return cost;

            for(int[] direction : directions) {
                int adjX = curr.x + direction[0];
                int adjY = curr.y + direction[1];
                if(validCell(adjX, adjY, row, col) && !visited[adjX][adjY]) {
                    int currDiff = Math.abs(heights[adjX][adjY] - heights[curr.x][curr.y]);
                    int maxDiff = Math.max(currDiff, differenceMatrix[x][y]);
                    if(differenceMatrix[adjX][adjY] > maxDiff) {
                        differenceMatrix[adjX][adjY] = maxDiff;
                        pq.add(new Cell(adjX, adjY, maxDiff));
                    }
                }
                    
            }
        }
        return differenceMatrix[row-1][col-1];
    }

    public boolean validCell(int x, int y, int row, int col) {
        return (x < row && y < col && x >= 0 && y >= 0);
    }
}
class Cell {
    int x;
    int y;
    Integer difference;

    Cell(int x, int y, Integer difference) {
        this.x = x;
        this.y = y;
        this.difference = difference;
    }
}