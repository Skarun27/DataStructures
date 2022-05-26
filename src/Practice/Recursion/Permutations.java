package Practice.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> sublist = new ArrayList();
        permutations(0, sublist, list, nums);
        return list;
    }
    
    static void permutations(int ind, List<Integer> sublist, List<List<Integer>> list, int[] nums) {
        if(ind == nums.length) {
            sublist = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                sublist.add(nums[i]);
            }
            list.add(sublist);
            return;
        }
        for(int i=ind; i<nums.length; i++) {
            swap(ind, i, nums);
            permutations(ind+1, sublist, list, nums);
            swap(ind, i, nums);
        }
    }
    
    static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
