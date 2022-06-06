package LeetcodeContests;

import java.util.Arrays;

public class leetcodewc1 {
    public static int partitionArray(int[] nums, int k) {
        
        Arrays.sort(nums);
        int low = 0;
        int count = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] - nums[low] > k) {
                count++;
                low = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(partitionArray(arr, 1));
    }
}
