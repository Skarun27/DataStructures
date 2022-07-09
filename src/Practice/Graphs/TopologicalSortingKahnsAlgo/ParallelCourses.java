package Practice.Graphs.TopologicalSortingKahnsAlgo;
import java.util.*;

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n+1];
        
        for(int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<relations.length; i++) {
            
            adjList.get(relations[i][0]).add(relations[i][1]);
            indegree[relations[i][1]]++;
        }
        
        int entries = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                entries++;
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int vertex = queue.poll();
                for(int neighbor: adjList.get(vertex)) {
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0) {
                        queue.add(neighbor);
                        entries++;
                    }
                }
            }
            count++;
        }
        
        for(int i: indegree) {
            if(indegree[i] > 0)
                return -1;
        }
        return count;
    }
}