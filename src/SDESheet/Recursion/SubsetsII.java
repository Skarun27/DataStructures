package SDESheet.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsetList = new ArrayList<>();
        subsets(0, new ArrayList<>(), subsetList, nums);
        return subsetList;
    }

    static void subsets(int ind, List<Integer> subset, List<List<Integer>> subsetList, int[] nums) {
        subsetList.add(new ArrayList<>(subset));
        for(int i=ind; i<nums.length; i++) {
            if(i != ind && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            subsets(i+1, subset, subsetList, nums);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
