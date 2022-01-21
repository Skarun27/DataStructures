package EasyProblems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

    /* Approach 1:
    * Created a map with nums[i] as key, and array of count, leftmost occurrence and rightmost occurrence as value.
    * This way we can find degree and sub-array length in the same iteration.
    */

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()){
            if (value[0] > degree){
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree){
                res = Math.min( value[2] - value[1] + 1, res);
            }
        }
        return res;
    }

    /*
    * Approach 2:
    * Create three diff maps for storing leftmost occurrence, rightmost occurrence and count of each unique element in the array
    * This method needs two different iteration to find degree and subarray length of elements.

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(),
                count = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int x = nums[i];
            if(left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x,0) + 1);
        }

        int degree = Collections.max(count.values());
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for(int x: count.keySet()) {
            if(count.get(x) == degree)
                min = Math.min(min, right.get(x) - left.get(x) + 1);
        }
        return min;
    }
    */
}
