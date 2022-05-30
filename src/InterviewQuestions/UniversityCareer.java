package InterviewQuestions;
import java.util.*;

class UniversityCareer {
    public static void main(String[] args) {
        List<Integer> arrival1 = new ArrayList<>(Arrays.asList(1,3,3,5,7));
        List<Integer> duration1 = new ArrayList<>(Arrays.asList(2,2,1,2,1));
        System.out.println(maxEvents(arrival1, duration1));
        List<Integer> arrival2 = new ArrayList<>(Arrays.asList(1,3,3,5,7, 6, 9));
        List<Integer> duration2 = new ArrayList<>(Arrays.asList(2,2,1,2,1, 10, 2));
        System.out.println(maxEvents(arrival2, duration2));
    }

    private static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        List<List<Integer>> events = new ArrayList<>();
        int drop = 0;
        int numOfEvents = arrival.size();
        for(int i=0;i<arrival.size();i++) {
            events.add(new ArrayList<>(Arrays.asList(arrival.get(i), arrival.get(i) + duration.get(i))));
        }
        Collections.sort(events, (a, b)->(a.get(1) - b.get(1)));
        int currTime = events.get(0).get(1);

        for(int i=1;i<numOfEvents;i++) {
            List<Integer> cur = events.get(i);
            if(cur.get(0) < currTime)
                drop++;
            else {
                currTime = cur.get(1);
            }
        }
        return numOfEvents - drop;
    }
}