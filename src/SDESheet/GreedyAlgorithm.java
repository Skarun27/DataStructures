package SDESheet;

import java.util.Arrays;

public class GreedyAlgorithm {
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int[][] meetings = new int[n][2];
        for(int i=0; i<n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        Arrays.sort(meetings, (int[] a, int[] b) -> a[1] - b[1]);

        int endTime = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            if(meetings[i][0] > endTime) {
                count++;
                endTime = meetings[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1,3,0,5,8,5};
        int[] end = new int[]{2,4,6,7,9,9};
        System.out.println(maxMeetings(start, end, start.length));
    }
}
