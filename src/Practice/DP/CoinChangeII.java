package Practice.DP;

public class CoinChangeII {
    public static int change(int amount, int[] coins) {
        int[] comb = new int[amount+1];
        comb[0] = 1;
        for(int coin: coins) {
            for(int i=coin; i<amount+1; i++) {
                comb[i] = comb[i] + comb[i-coin];
            }
        }
        return comb[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(change(5, coins));
    }
}

