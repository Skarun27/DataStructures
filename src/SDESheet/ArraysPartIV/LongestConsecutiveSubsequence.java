package SDESheet.ArraysPartIV;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int maxCount = 0, count = 0;
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        for(int i=0; i<nums.length; i++) {

            if(!set.contains(nums[i]-1)) {
                int num = nums[i];
                count++;
                while(set.contains(++num)) {
                    count++;
                }
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{400, 1, 100, 2, 3, 101, 102, 4, 5};
        System.out.println(longestConsecutive(arr));
    }
}
