package EasyProblems;
//Problem 1475 Leetcode

import java.util.Stack;

public class FinalPricesWithSpecialDiscount {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i])
                prices[stack.pop()] -= prices[i];
            stack.push(i);
        }
        return prices;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{8,4,6,2,3};
        System.out.println(finalPrices(ar));
    }
}
