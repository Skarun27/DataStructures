package SDESheet.ArraysPartIV;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] indxArr = new int[2];

        HashMap<Integer, Integer> sum = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(sum.containsKey(target-nums[i])) {
                return new int[]{sum.get(target-nums[i]), i};
            }
            sum.put(nums[i], i);
        }
        return null;
    }
}
