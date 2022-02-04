package SDESheet.LinkedListAndArrays;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                count++;
            }
            else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
