package SDESheet.ArraysPartII;
// Leetcode: https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicateNumber {
    /**
     Whenever the elements of array are in range of array length (for eg: all array elements of length n+1
     will consist of elements with value in the range 1-n), then try navigating to index of array corresponding
     the value of current position element.
     For eg:
     slow = nums[slow];
     fast = nums[nums[fast]];.
     */

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }
}
