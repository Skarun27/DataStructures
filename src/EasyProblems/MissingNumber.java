package EasyProblems;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1};
        System.out.println(missingNumber(nums));
    }
}
