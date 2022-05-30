package InterviewQuestions;
import  java.util.*;

class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q =
                new PriorityQueue<Integer>(k, new Comparator<Integer>(){
                    public int compare(Integer a, Integer b) {
                        return a-b;
                    }
                });

        for(int num: nums) {
            q.add(num);
            if(q.size() > k) {
                q.poll();
            }
        }

        return q.poll();
    }

    public static void main(String[] args) {
        int[] n = {3,2,1,5,6,4};
        System.out.println(findKthLargest(n, 2));

    }
}
