package Topics.DP;

import java.util.HashMap;

public class HouseRobber {

    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    // Memoization method
    public static int houseRobber(int[] arr, int index) {

        if(index == 0) {
            return arr[0];
        }

        if(index == 1) {
            return Math.max(arr[0], arr[1]);
        }

        if(!memo.containsKey(index)) {
            memo.put(index, Math.max(houseRobber(arr, index-1), houseRobber(arr, index-2) + arr[index]));
        }

        return memo.get(index);
    }

    // Tabulation method
    public static int houseRobber(int[] arr) {

        int[] res = new int[arr.length];
        res[0] = arr[0];
        res[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<arr.length; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + arr[i]);
        }

        return res[arr.length-1];
    }
    
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(houseRobber(arr));
    }
}
