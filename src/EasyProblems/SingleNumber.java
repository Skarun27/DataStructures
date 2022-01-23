package EasyProblems;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int a = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            a ^= nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
