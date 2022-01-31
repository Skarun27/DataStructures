package SDESheet.ArraysPartII;

import java.util.Arrays;

public class mergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        if(intervals.length == 1) return intervals;
        int[][] result = new int[intervals.length+1][2];
        int j = -1;
        for(int i=0; i<intervals.length; i++) {
            if(j == -1 || result[j][1] < intervals[i][0]) {
                result[++j][0] = intervals[i][0];
                result[j][1] = intervals[i][1];
            }
            else {
                result[j][1] = Math.max(result[j][1], intervals[i][1]);
            }
        }
        int[][] output = Arrays.copyOfRange(result, 0, j+1);
        return output;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{4,6}};
        System.out.println(merge(arr));
    }
}
