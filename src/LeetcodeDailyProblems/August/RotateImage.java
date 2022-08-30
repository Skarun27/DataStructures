package LeetcodeDailyProblems.August;

public class RotateImage {
    
    public void rotate(int[][] matrix) {
        
        int colSize = matrix[0].length - 1;
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length/2; j++) {
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][colSize-j];
                matrix[i][colSize-j] = temp;
            }
        }
    }
}
