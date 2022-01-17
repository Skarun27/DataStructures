import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HRT_Q2 {

    private static final int m = 1_000_000_007;

    public static int numWays(String s) {
        int countOfA = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a')
                countOfA += 1;
        }
        if (countOfA == 0) {
            return (int) ((n - 2L) * (n - 1L) / 2 % m);
        }
        if (countOfA % 3 != 0) {
            return 0;
        }
        int aInEachSplitedBlock = countOfA / 3;
        long waysOfFirstCut = 0, waysOfSecondCut = 0;
        for (int i = 0, count = 0; i < n; ++i) {
            if(s.charAt(i) == 'a')
                count += 1;
            if (count == aInEachSplitedBlock) {
                ++waysOfFirstCut;
            } else if (count == 2 * aInEachSplitedBlock) {
                ++waysOfSecondCut;
            }
        }
        return (int) (waysOfFirstCut * waysOfSecondCut % m);
    }

    public static void main(String[] args) {
        String s = "ababa";
        int a = numWays(s);
        System.out.println(a);
    }
}
