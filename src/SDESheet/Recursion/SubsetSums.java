package SDESheet.Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        recursiveSum(arr, 0, 0, N, list);
        Collections.sort(list);
        return list;
    }

    static void recursiveSum(ArrayList<Integer> arr,
                      int ind, int sum, int N, ArrayList<Integer> list) {
        if(ind == N) {
            list.add(sum);
            return;
        }

        recursiveSum(arr, ind+1, sum+arr.get(ind), N, list);
        recursiveSum(arr, ind+1, sum, N, list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        System.out.println(subsetSums(arr, arr.size()));
    }
}
