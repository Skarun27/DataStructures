package SDESheet.Recursion;

import java.util.ArrayList;
// import java.util.List;

public class SubsequenceExistsWithSumK {
    
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static boolean subsequence(int ind, ArrayList<Integer> list, ArrayList<Integer> arr, int sum, int n, int k) {
        if(ind == n) {
            if(sum == k)
                return true;
            else 
                return false;
        }

        sum += list.get(ind);
        if(subsequence(ind+1, list, arr, sum, n, k)) return true;

        sum -= list.get(ind);
        if(subsequence(ind+1, list, arr, sum, n, k)) return true;

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(subsequence(0, list, arr, 0, list.size(), 2));
    }
}
