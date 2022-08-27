package Topics.DP;

public class LongestCommonSubsequence {
    private int[][] memo;
    
    public int longestCommonSubsequence(String text1, String text2) {
        this.memo = new int[text1.length() + 1][text2.length() + 1];
        return longestSubseq(0,0, text1, text2);
    }
    
    public int longestSubseq(int i, int j, String text1, String text2) {
        
        if(i == text1.length() || j == text2.length())
            return 0;
        
        if(memo[i][j] != 0)
            return memo[i][j];
        
        if(text1.charAt(i) == text2.charAt(j))
            memo[i][j] = 1 + longestSubseq(i+1, j+1, text1, text2);
        
        else
            memo[i][j] = Math.max(longestSubseq(i+1, j, text1, text2), 
                                  longestSubseq(i, j+1, text1, text2));
        
        return memo[i][j];
    }
}
