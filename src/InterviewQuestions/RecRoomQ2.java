package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class RecRoomQ2 {
    
    public static List<Integer> getMinOperations(List<Integer> kValues) {
        
        List<Integer> resList = new ArrayList<>();
        for(int kValue: kValues) {
            int operationCount = getMinOperation(kValue);
            resList.add(operationCount);
        }

        return resList;
    }

    public static int getMinOperation(int kValue) {
        
        int dp[] = new int[kValue + 1];
 
        for(int i = 1; i <= kValue; i++) {
            dp[i] = dp[i - 1] + 1;
                
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        return dp[kValue];
    }

    public static void main(String[] args) {
        
        List<Integer> kValues = new ArrayList<>();
        kValues.add(5);
        kValues.add(3);
        System.out.println(getMinOperations(kValues)); 
    }
}
