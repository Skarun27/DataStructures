package LeetcodeDailyProblems.August;

import java.util.Arrays;

public class reorderedPowerOf2 {
    public boolean reorderedPower(int n) {
        
        int[] nArr = calcSum(n);
        for(int i=0; i<31; i++) {
            
            if(Arrays.equals(nArr, calcSum((int)Math.pow(2, i))))
                return true;
        }
        return false;
    }
    
    public int[] calcSum(int n) {
        
        int[] ans = new int[10];
        while(n > 0) {
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
}
