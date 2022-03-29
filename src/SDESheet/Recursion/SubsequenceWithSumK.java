package SDESheet.Recursion;

import java.util.ArrayList;
// import java.util.List;

public class SubsequenceWithSumK {
    
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void subsequence(int ind, ArrayList<Integer> list, ArrayList<Integer> arr, int sum, int n, int k) {
        if(ind == n) {
            if(sum == k)
                res.add(new ArrayList<>(arr));
            return;
        }

        arr.add(list.get(ind));
        sum += list.get(ind);
        subsequence(ind+1, list, arr, sum, n, k);

        arr.remove(arr.size()-1);
        sum -= list.get(ind);
        subsequence(ind+1, list, arr, sum, n, k);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        subsequence(0, list, arr, 0, list.size(), 2);
        for(ArrayList<Integer> subList: res) {
            System.out.println(subList);
        }
    }
}
