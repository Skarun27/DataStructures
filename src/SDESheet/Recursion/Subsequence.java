package SDESheet.Recursion;

import java.util.ArrayList;
// import java.util.List;

public class Subsequence {
    
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static void subsequence(int ind, ArrayList<Integer> list, ArrayList<Integer> arr, int n) {
        if(ind == n) {
            res.add(new ArrayList<Integer>(arr));
            return;
        }

        arr.add(list.get(ind));
        subsequence(ind+1, list, arr, n);
        arr.remove(arr.size()-1);
        subsequence(ind+1, list, arr, n);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        subsequence(0, list, arr, list.size());
        for(ArrayList<Integer> subList: res) {
            System.out.println(subList);
        }
    }
}
