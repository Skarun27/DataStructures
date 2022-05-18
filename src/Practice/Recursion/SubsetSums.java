package Practice.Recursion;

import java.util.ArrayList;

public class SubsetSums {
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(1);
        System.out.println(subsetSums(arr, list, 0, 0));
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, ArrayList<Integer> list, int ind, int sum) {
        
        if(ind >= arr.size()) {
            list.add(sum);
            return list;
        }

        sum += arr.get(ind);
        subsetSums(arr, list, ind+1, sum);
        sum -= arr.get(ind);
        subsetSums(arr, list, ind+1, sum);

        return list;
    }
}
