package SDESheet.GreedyAlgorithm;

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int depTime = 0;
        int count = 1;
        for(int i=1; i<n; i++) {
            if(arr[i] > dep[depTime]) {
                depTime++;
            }
            else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,0,5,8,5};
        int[] dep = new int[]{2,4,6,7,9,9};
        System.out.println(findPlatform(arr, dep, dep.length));
    }
}
