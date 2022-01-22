package EasyProblems;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int leftZero = -1;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(leftZero == -1 && nums[i] == 0)
                leftZero = i;
            if(leftZero != -1 && nums[i] != 0 && leftZero < i) {
                int temp = leftZero;
                nums[leftZero] = nums[i];
                nums[i] = 0;
                while(nums[leftZero] != 0) {
                    leftZero++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(arr);
    }
}
