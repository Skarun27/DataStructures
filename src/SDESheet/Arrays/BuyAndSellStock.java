package SDESheet.Arrays;
// LeetCode: #121 | https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if(prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
            else if(prices[i] - buyPrice > maxProfit){
                maxProfit = prices[i] - buyPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
