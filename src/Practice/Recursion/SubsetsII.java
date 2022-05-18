package Practice.Recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void subsetsWithDup(int[] arr, List<Integer> subList, List<List<Integer>> list, int ind) {
        list.add(new ArrayList<>(subList));
        for(int i=ind; i<arr.length; i++) {
            if(i!=ind && arr[i] == arr[i-1]) continue;
            subList.add(arr[i]);
            subsetsWithDup(arr, subList, list, i+1);
            subList.remove(subList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        subsetsWithDup(nums, subList, list, 0);
        System.out.println(list);
    }
}
