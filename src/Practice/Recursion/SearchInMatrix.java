package Practice.Recursion;

public class SearchInMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, 20));
    }   

    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++) {
            if(binarySearch(matrix[i], 0, matrix[i].length-1, target))
                return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        int mid = (end+start)/2;
        if(arr[mid] == target) return true;
        
        if(start < end) {
            if(target < arr[mid])
                return binarySearch(arr, start, mid, target);
            else 
                return binarySearch(arr, mid+1, end, target);
        }
        return false;
    }
}
