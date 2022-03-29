package SDESheet.Recursion;

import java.util.ArrayList;

public class SubsequenceCountWithSumK {
    
    public static int subsequenceCountWithSumK(int ind, int sum, ArrayList<Integer> list, int k, int n) {

        if(ind == n)
            if(sum == k)
                return 1;
            else 
                return 0;
        
        sum += list.get(ind);
        int l = subsequenceCountWithSumK(ind+1, sum, list, k, n);
        sum -= list.get(ind);
        int r = subsequenceCountWithSumK(ind+1, sum, list, k, n);

        return l+r;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        System.out.println(subsequenceCountWithSumK(0, 0, list, 2, list.size()));
    }
}
