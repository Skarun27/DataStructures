package SDESheet.BinarySearch;

public class SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
