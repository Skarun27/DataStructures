package SDESheet;

import java.util.HashMap;

public class Amazon1 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,7,3,4};

        int res = impl(arr, 3);
        System.out.println(res);
    }

    public static int impl(int[] arr, int k) {

        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<k+i && j < arr.length; j++) {
                int price = arr[j];
                if(!map.containsKey(price)) {
                    map.put(price, j);
                    sum += price;
                }
                else
                    break;
            }
            if(sum > max) {
                max = sum;
            }
            sum = 0;
        }

        return max;
    }
    
}
