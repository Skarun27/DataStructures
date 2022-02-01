package SDESheet.ArraysPartIII;

public class SearchInA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row; i++) {
            if(matrix[i][0] <= target && matrix[i][col-1] >= target) {
                for(int j=0; j<col; j++) {
                    if(matrix[i][j] == target)
                        return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,5,7},{10,11,16,20}{23,30,34,60}};
        System.out.println(searchMatrix(arr, 3));
    }
}
