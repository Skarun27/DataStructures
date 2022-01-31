package SDESheet.ArraysPartI;
// Variation of Dutch National Flag Algorithm.
// LeetCode: https://leetcode.com/problems/maximum-subarray/
public class Sort0s1s2s {
    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(low++, mid++, nums);
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else if(nums[mid] == 2) {
                swap(mid, high--, nums);
            }
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{};
        sortColors(arr);
    }
}
