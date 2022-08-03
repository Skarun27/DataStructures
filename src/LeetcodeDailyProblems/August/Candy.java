package LeetcodeDailyProblems.August;

public class Candy {
    public int candy(int[] ratings) {
        
        int minCandies = 0;
        int n = ratings.length;
        if(n==1) return 1;
        
        int[] candies = new int[n];
        candies[0] = 1;
        
        for(int i=1; i<n; i++) {
            if(ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            }
            else candies[i] = 1;
        }
        
        minCandies = candies[n-1];
        
        for(int i=n-2; i>=0; i--) {
            if(ratings[i+1] < ratings[i]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            minCandies += candies[i];
        }
        
        return minCandies;
    }
}
