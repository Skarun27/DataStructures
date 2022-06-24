package Practice.Graphs.DFS;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        if(tickets.size() == 0)
            return new ArrayList<String>();
        
        HashMap<String, LinkedList<String>> itMap = new HashMap<>();
        for(int i=0; i<tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            if(itMap.containsKey(from)) {
                LinkedList<String> val = itMap.get(from);
                val.add(tickets.get(i).get(1));
                itMap.put(from, val);
            }
            else {
                LinkedList<String> val = new LinkedList<>();
                val.add(tickets.get(i).get(1));
                itMap.put(from, val);
            }
        }
        
        for(Map.Entry<String, LinkedList<String>> entry: itMap.entrySet()) {
            Collections.sort(entry.getValue());   
        }
        
        // List<String> itinerary = dfs(itMap, new ArrayList<String>(), "JFK");
        LinkedList<String> itinerary = new LinkedList<String>();
        dfs(itMap, itinerary, "JFK");
        return itinerary;
    }
        
    public void dfs(HashMap<String, LinkedList<String>> itMap, LinkedList<String> list, String from) {

        if(itMap.containsKey(from)) {
            LinkedList<String> destList = itMap.get(from);
            while(!destList.isEmpty()) {
                String dest = destList.pollFirst();
                dfs(itMap, list, dest);
            }
        }
        list.offerFirst(from);
    }
}
