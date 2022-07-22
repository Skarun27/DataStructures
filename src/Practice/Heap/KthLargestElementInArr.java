package Practice.Heap;

public class KthLargestElementInArr {
    public int findKthLargest(int[] nums, int k) {
        
        int size = nums.length;
        return quickSelect(0, size-1, size-k, nums);
    }
    
    public int quickSelect(int left, int right, int kSmallest, int[] nums) {
        
        if(left == right) return nums[left];
        
        int pivotIdx = partition(left, right, nums);
        
        if(pivotIdx == kSmallest)
            return nums[pivotIdx];
        
        else if(pivotIdx < kSmallest) 
            return quickSelect(pivotIdx+1, right, kSmallest, nums);
        
        return quickSelect(left, pivotIdx-1, kSmallest, nums);
    }
    
    public int partition(int left, int right, int[] nums) {
        
        int pivotIdx = right;
        int pivot = nums[pivotIdx];
        int pointer = left;
        
        for(int i=left; i<=right; i++) {
            if(nums[i] < pivot) {
                swap(pointer, i, nums);
                pointer++;
            }    
        }
        
        swap(pivotIdx, pointer, nums);
        return pointer;
    }
    
    public void swap (int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
