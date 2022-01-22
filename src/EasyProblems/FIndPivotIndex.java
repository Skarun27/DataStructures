package EasyProblems;

public class FIndPivotIndex {

    public static int pivotIndex(int[] nums) {
        int total = 0, sum = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if ((sum - nums[i]) * 2 == total - nums[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,1};
        System.out.println(pivotIndex(nums));
    }
}
