package SDESheet.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteUsingBFS {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] visited = new int[V];

        for(int i=0; i<V; i++) {
            visited[i] = -1;
        }
        for(int i=0; i<V; i++) {
            if(visited[i] == -1)
                if(!bfs(graph, i, visited))
                    return false;
        }
        return true;
    }

    public boolean bfs(int[][] graph, int node, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            for(int j=0; j<graph[curr].length; j++) {
                if(visited[curr] == visited[graph[curr][j]])
                    return false;
                else if(visited[graph[curr][j]] == -1) {
                    queue.add(graph[curr][j]);
                    visited[graph[curr][j]] = 1 - visited[curr];
                }
            }
        }
        return true;
    }
}
