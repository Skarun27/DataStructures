package SDESheet.ArraysPartIV;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWith0Sum {
    public static int maxLen(int arr[], int n)
    {
        // Your code here
        int prefixSum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<arr.length; i++) {
            prefixSum += arr[i];

            if(prefixSum == 0) {
                maxLen = i+1;
            }

            if(map.containsKey(prefixSum)) {
                maxLen = Math.max(i-map.get(prefixSum), maxLen);
            }
            else map.put(prefixSum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(arr, 8));
    }
}
