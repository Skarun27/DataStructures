package SDESheet.BinarySearch;

public class SearchInRotatedArray {
    static int result = -1;
    static int start = 0;
    static int end = 0;

    public static int search(int[] nums, int target) {
        end = nums.length-1;
        while(start <= end) {
            int half = (start+end)/2;

            if (nums[half] == target) return half;

            else if(nums[start] <= nums[half]) {
                if(target >= nums[start] && target < nums[half]) {
                    end = half-1;
                }
                else
                    start = half+1;
            }

            else {
                if(target > nums[half] && target <= nums[end])
                    start = half+1;
                else
                    end = half-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
