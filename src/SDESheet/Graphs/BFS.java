package SDESheet.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            Integer val = queue.remove();
            list.add(val);
            ArrayList<Integer> adjList = adj.get(val);
            for(int i=0; i<adjList.size(); i++) {
                if(!visited.contains(adjList.get(i))) {
                    queue.add(adjList.get(i));
                    visited.add(adjList.get(i));
                }
            }
        }
        return list;
    }
}
