package Topics.Recursion;

public class BinarySearch {

    public static boolean binarySearch(int[] arr, int start, int end, int target) {

        int mid = (start + end)/2;

        if(arr[mid] == target)
            return true;

        if(start < end) {
            if(target < arr[mid])
                return binarySearch(arr, start, mid, target);
            else
                return binarySearch(arr, mid+1, end, target);
        }

        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,2,5,6,8,9,13};
        System.out.println(binarySearch(arr, 0, 7, 11));
    }
}
