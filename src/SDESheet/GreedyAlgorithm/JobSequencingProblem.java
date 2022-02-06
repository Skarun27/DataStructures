package SDESheet.GreedyAlgorithm;

import java.util.Arrays;

public class JobSequencingProblem {
    static int[] jobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (Job a, Job b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for(int i=0; i<n; i++) {
            maxDeadline = Math.max(arr[i].deadline, maxDeadline);
        }

        int[] jobQueue = new int[maxDeadline];

        int[] res = new int[2];
        for(int i=0; i<n; i++) {

            int ind = arr[i].deadline - 1;
            while(ind >= 0 && jobQueue[ind] != 0) {
                ind--;
            }
            if(ind >= 0) {
                jobQueue[ind] = arr[i].id;
                res[1] += arr[i].profit;
                res[0]++;
            }
        }
        return res;
    }

    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static void main(String[] args) {
        int[][] jobs = new int[][]{{1,4,20},{2,1,10},{3,1,40},{4,1,30}};
        Job[] arr = new Job[jobs.length];
        for(int i=0; i<jobs.length; i++) {
            Job job = new Job(jobs[i][0], jobs[i][1], jobs[i][2]);
            arr[i] = job;
        }
        int[] res = new int[2];
        res = jobScheduling(arr, arr.length);
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
