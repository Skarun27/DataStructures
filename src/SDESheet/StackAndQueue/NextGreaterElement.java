package SDESheet.StackAndQueue;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static Integer[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        Stack< Integer > st = new Stack< >();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (!st.isEmpty()) map.put(nums2[i], st.peek());
            else map.put(nums2[i], -1);

            st.push(nums2[i]);
        }

        Integer res[] = new Integer[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr1[]={1,3,4,2};
        int arr2[]={4,1,2};

        Integer arr3[] = nextGreaterElement(arr2, arr1);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
