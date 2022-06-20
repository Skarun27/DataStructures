package Practice.DP;

public class InterleavingString {
    String s1;
    String s2;
    String s3;
    int[][] memo;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memo = new int[s1.length()][s2.length()];
        
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return dp(0, 0, 0);
    }
    
    public boolean dp(int i, int j, int k) {
        
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1 ? true : false;
        }
        
        boolean s1match = false;
        boolean s2match = false;
        boolean res = false;
        
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            s1match = dp(i+1, j, k+1);
        }
        
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            s2match = dp(i, j+1, k+1);
        }
        
        if(s1match || s2match)
            res = true;
        
        memo[i][j] = res ? 1 : 0;
        
        return res;
    }
}
