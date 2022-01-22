package EasyProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minAbsoluteDiff {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1; i<n; i++) {
            if(minDiff > arr[i] - arr[i-1]) {
                minDiff = arr[i] - arr[i-1];
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(arr[i-1]);
                newList.add(arr[i]);
                list.clear();
                list.add(newList);
            }
            else if(minDiff == arr[i] - arr[i-1]) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(arr[i-1]);
                newList.add(arr[i]);
                list.add(newList);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(arr));
    }
}
