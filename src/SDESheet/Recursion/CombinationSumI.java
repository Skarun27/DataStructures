package SDESheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> sublist = new ArrayList();
        findCombinations(0, target, sublist, list, candidates);
        return list;
    }

    static void findCombinations(int ind, int target, List<Integer> sublist, List<List<Integer>> list, int[] candidates) {
        if(ind == candidates.length) {
            if(target == 0) {
                list.add(new ArrayList(sublist));
            }
            return;
        }

        if(candidates[ind] <= target) {
            sublist.add(candidates[ind]);
            findCombinations(ind, target - candidates[ind], sublist, list, candidates);
            sublist.remove(sublist.size() - 1);
        }
        findCombinations(ind+1, target, sublist, list, candidates);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }
}
