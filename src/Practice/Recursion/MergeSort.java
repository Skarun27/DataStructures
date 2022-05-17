package Practice.Recursion;

public class MergeSort {

    public static void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, end);
        }
    }

    public static void merge(int[] arr, int start, int end) {
        int[] temp = new int[end-start+1];
        
        int mid = (end+start)/2;
        int i = start, j = mid+1, curr = 0;
        
        while(i <= mid && j <= end) {
            if(arr[i] > arr[j]) {
                temp[curr++] = arr[j++];
            }
            else {
                temp[curr++] = arr[i++];
            }
        }

        while(i <= mid) {
            temp[curr++] = arr[i++];
        }
        while(j <= end) {
            temp[curr++] = arr[j++];
        }
        for(i=start; i<=end; i++) {
            arr[i] = temp[i-start];
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{13,8,2,9,6,0,5,-1};
        mergeSort(arr, 0, 7);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
