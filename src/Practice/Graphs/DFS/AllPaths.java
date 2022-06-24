package Practice.Graphs.DFS;
import java.util.*;

public class AllPaths {
    boolean[] isVisited;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        isVisited = new boolean[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // boolean[] isVisited = new boolean[n];
        for(int i=0; i<edges.length; i++) {
            
            ArrayList<Integer> list1 = map.getOrDefault(edges[i][0], new ArrayList<Integer>());
            list1.add(edges[i][1]);
            map.put(edges[i][0], list1);
        }
        
        return dfs(edges, source, destination, map);
    }
    
    public boolean dfs(int[][] edges, int source, int destination, HashMap<Integer, ArrayList<Integer>> map) {
        if (isVisited[source]) return false;
        isVisited[source] = true;
        
        if(!map.containsKey(source))
            if(source != destination) return false;
        
        ArrayList<Integer> neighbors = map.get(source);
        if(neighbors != null) {
            for(int dest: neighbors) {
                boolean isPresent = dfs(edges, dest, destination, map);
                if(!isPresent) return false;
            }    
        }
        isVisited[source] = false;
        return true;
    }
}
