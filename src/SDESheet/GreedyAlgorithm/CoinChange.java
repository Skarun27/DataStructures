package SDESheet.GreedyAlgorithm;

import java.util.ArrayList;

public class CoinChange {
    static ArrayList<Integer> coinChange(int[] coins, int V) {
        int n = coins.length;
        ArrayList < Integer > ans = new ArrayList < > ();
        for (int i = n - 1; i >= 0; i--) {
            while (V >= coins[i]) {
                V -= coins[i];
                ans.add(coins[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        System.out.println(coinChange(coins, 49));
    }
}
