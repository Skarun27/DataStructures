package Practice.DP;

public class PaintHouse {
    public static int minCost(int[][] costs) {
        
        int[][] paintCost = new int[costs.length][3];    
        paintCost[0] = costs[0];
        int min = Math.min(paintCost[0][0], Math.min(paintCost[0][1] , paintCost[0][2]));
        
        for(int i=1; i<costs.length; i++) {
            min = Integer.MAX_VALUE;
            for(int j=0; j<3; j++) {
                if(j == 0)
                    paintCost[i][j] = costs[i][j] + Math.min(paintCost[i-1][1] , paintCost[i-1][2]);
                
                if(j == 1)
                    paintCost[i][j] = costs[i][j] + Math.min(paintCost[i-1][0] , paintCost[i-1][2]);
                
                if(j == 2)
                    paintCost[i][j] = costs[i][j] + Math.min(paintCost[i-1][0] , paintCost[i-1][1]);
                
                min = Math.min(min, paintCost[i][j]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(costs));
    }
}
