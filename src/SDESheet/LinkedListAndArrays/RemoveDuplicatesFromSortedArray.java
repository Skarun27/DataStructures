package SDESheet.LinkedListAndArrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int l = 0, r = 1, n = nums.length;
        while(r < n) {
            if(nums[l] != nums[r]) {
                int temp = nums[r];
                nums[r] = nums[l+1];
                nums[l+1] = temp;
                l++;
            }
            r++;
        }
        return l+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        System.out.println(removeDuplicates(arr));
    }
}
