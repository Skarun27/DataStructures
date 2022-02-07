package SDESheet.Recursion;

import java.util.ArrayList;

public class KthPermutationSequence {

    public static String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> numbers= new ArrayList<>();

        for(int i=1; i<n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        String s = "";
        k -= 1;

        while(true) {
            s = s + numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() == 0)
                break;
            k = k % fact;
            fact = fact/numbers.size();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 17));
    }
}
