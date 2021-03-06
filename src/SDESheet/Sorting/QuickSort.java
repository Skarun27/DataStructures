package SDESheet.Sorting;

public class QuickSort {

    static int partition(int[] arr, int low, int high) {
        int i = low-1;
        int pivot = arr[high];
        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        return i+1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,80,30,90,40,50,70};
        quickSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }

}
