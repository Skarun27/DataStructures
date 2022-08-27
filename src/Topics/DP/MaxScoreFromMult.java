package Topics.DP;

class MaxScoreFromMult {
        
    int[] nums;
    int[] multipliers;
    int[][] maxScore;

    public int maximumScore(int[] nums, int[] multipliers) {
        
        this.nums = nums;
        this.multipliers = multipliers;
        int m = multipliers.length;
        maxScore = new int[m][m];
        
        return dp(0, 0);
    }

    public int dp(int i, int left) {
        
        if(i == multipliers.length)
            return 0;
        
        int right = nums.length - 1 - (i - left);
        
        if(maxScore[i][left] == 0) {
            maxScore[i][left] = Math.max(dp(i+1, left+1) + multipliers[i] * nums[left] , 
                                dp(i+1, left) + multipliers[i] * nums[right]);
        }
        
        return maxScore[i][left];     
    }
}