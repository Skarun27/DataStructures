package Practice.Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;

public class FindIfPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[] isVisited = new boolean[n];
        for(int i=0; i<edges.length; i++) {
            ArrayList<Integer> list1 = map.getOrDefault(edges[i][0], new ArrayList<Integer>());
            list1.add(edges[i][1]);
            map.put(edges[i][0], list1);
            ArrayList<Integer> list2 = map.getOrDefault(edges[i][1], new ArrayList<Integer>());
            list2.add(edges[i][0]);
            map.put(edges[i][1], list2);
        }
        
        return pathExists(map, source, destination, isVisited);
    }
    
    public boolean pathExists(HashMap<Integer, ArrayList<Integer>> 
                              map, int source, int destination, boolean[] isVisited) {
        isVisited[source] = true;
        if(!map.containsKey(source)) return false;
        ArrayList<Integer> list = map.get(source);
        
        for(int i=0; i<list.size(); i++) {
            if(isVisited[list.get(i)]) continue;
            if(list.get(i) == destination) return true;
            if(pathExists(map, list.get(i), destination, isVisited))
                return true;
        }
        return false;
    }
}
