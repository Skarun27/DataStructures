package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class Google2 {
    
    public static int uniqueArr(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }
        // Arrays.sort(arr);
        int count = 1;
        for(int i=1; i<arr.length; i++) {
            if(set.contains(arr[i])) {
                int reversedNum = reverse(arr[i]);
                if(set.contains(reversedNum) || reversedNum<=9){
                    continue;
                }
                else{
                    set.add(reversedNum);
                }
            }
            count++;
        }
        System.out.println(set.toString());

        return count;
    }

    public static int reverse(int num) {
        int res = 0;
        while(num > 0) {
            int digit = num%10;
            res = res * 10 + digit;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{15,21,50,50};
        int[] arr2 = new int[]{21,21,99,99,12,12};
        int[] arr3 = new int[]{20,21,22,23,20};

        System.out.println(uniqueArr(arr2));
    }
}
