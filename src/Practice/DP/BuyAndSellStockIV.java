package Practice.DP;

import SDESheet.BinaryTreeIII.MaxPathSum;

public class BuyAndSellStockIV {
    static int[][][] profit;
    static int[] prices;
    
    public static int maxProfit(int k, int[] prices) {
        profit = new int[prices.length][k+1][2];
        prices = prices;
        return dp(0, k, 0);
    }
    
    public static int dp(int i, int transactionsRemaining, int holding) {
        
        if(i == prices.length || transactionsRemaining == 0)
            return 0;
        
        if(profit[i][transactionsRemaining][holding] == 0) {
        
            if(holding == 0) {
                profit[i][transactionsRemaining][holding] = 
                    Math.max(dp(i+1, transactionsRemaining, 1) - prices[i], 
                             dp(i+1, transactionsRemaining, 0));
            }

            if(holding == 1) {
                profit[i][transactionsRemaining][holding] = 
                    Math.max(dp(i+1, transactionsRemaining-1, 0) + prices[i], 
                             dp(i+1, transactionsRemaining, 1));
            }
        }
        
        return profit[i][transactionsRemaining][holding];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,6,5,0,3};
        maxProfit(2, arr);
    }
}
