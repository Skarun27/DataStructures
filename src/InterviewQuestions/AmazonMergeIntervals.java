package InterviewQuestions;
import java.util.*;

    public class AmazonMergeIntervals {

        // Function that takes a set of intervals, merges
        // overlapping intervals and prints the result
        public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {

            intervals.sort((x, y) -> Integer.compare(x.get(0), y.get(0)));
            List<List<Integer>> list = new ArrayList<>();
            list.add(intervals.get(0));
            int index = 0; // Stores index of last element

            // Traverse all input Intervals
            for (int i = 1; i < intervals.size(); i++) {

                if (list.get(index).get(1) >= intervals.get(i).get(0)) {
                    // Merge previous and current Intervals
                    List<Integer> newList = new ArrayList<>();
                    newList.add(Math.min(list.get(index).get(0), intervals.get(i).get(0)));
                    newList.add(Math.max(list.get(index).get(1), intervals.get(i).get(1)));
                    list.add(index, newList);
                } else {
                    index++;
                    List<Integer> newList;
                    newList = intervals.get(i);
                    list.add(index, newList);
                }
            }
            List<List<Integer>> list1 = new ArrayList<>();
            if(list.size() > index+1)
                list1 = list.subList(0, index+1);
            return list1;
        }

        public static void main(String[] args) {
            List<List<Integer>> list = new ArrayList<>();

            list.add(new ArrayList<>(Arrays.asList(7, 7)));
            list.add(new ArrayList<>(Arrays.asList(2, 3)));
            list.add(new ArrayList<>(Arrays.asList(6, 11)));
            list.add(new ArrayList<>(Arrays.asList(1, 2)));
            System.out.println(mergeIntervals(list).toString());
        }
    }
