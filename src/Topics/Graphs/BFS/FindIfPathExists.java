package Topics.Graphs.BFS;
import java.util.*;

public class FindIfPathExists {
    public static boolean validPath(int n, int[][] edges, int start, int end) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(i, new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        boolean[] isVisited = new boolean[n];
        
        return bfs(list, queue, isVisited, start, end);
    }
    
    public static boolean bfs(ArrayList<ArrayList<Integer>> list, Queue<Integer> queue, boolean[] isVisited, int start, int end) {
        
        if(start == end) return true;
        
        if(!isVisited[start]) {
            for(int i=0; i<list.get(start).size(); i++) {
                queue.add(list.get(start).get(i));
            }
            isVisited[start] = true;
        }
        boolean isPresent = false;
        while(queue != null && queue.size()>0) {
            start = queue.remove();
            if(!isVisited[start] && !isPresent) {
                isPresent = bfs(list, queue, isVisited, start, end);
            }
        }
        return isPresent;
    }
}
