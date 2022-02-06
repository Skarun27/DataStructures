package SDESheet.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList();
        List<Integer> sublist = new ArrayList();
        findCombinations(0, target, sublist, list, candidates);
        return list;
    }

    static void findCombinations(int ind, int target, List<Integer> sublist, List<List<Integer>> list, int[] candidates) {
        if(target == 0) {
            list.add(new ArrayList(sublist));
            return;
        }

        for(int i=ind; i<candidates.length; i++) {
            if(i > ind && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] <= target) {
                sublist.add(candidates[i]);
                findCombinations(i+1, target - candidates[i], sublist, list, candidates);
                sublist.remove(sublist.size() - 1);
            }
            else break;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(nums, target));
    }
}
