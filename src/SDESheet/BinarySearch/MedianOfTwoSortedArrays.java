package SDESheet.BinarySearch;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;

        while(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = ((n1 + n2 + 1) / 2) - mid1;

            int left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];

            int right1 = mid1 == n1 ? Integer.MAX_VALUE : nums1[mid1];
            int right2 = mid2 == n2 ? Integer.MAX_VALUE : nums2[mid2];

            if(left1 <= right2 && left2 <= right1) {
                if((n1 + n2) % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return Math.max(left1, left2);
            }
            else {
                if(left1 > right2)
                    high = mid1 - 1;
                else
                    low = mid1 + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int array1[] = {2,3,6,7,9};
        int array2[] = {1,4,8,10};
        int m = array1.length;
        int n = array2.length;
        int k = 5;
        System.out.println("The element at the kth position in " +
                "the final sorted array is " + findMedianSortedArrays(array1,array2));

    }
}
