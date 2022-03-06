package SDESheet.Graphs;

public class BipartiteUsingDFS {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] visited = new int[V];

        for(int i=0; i<V; i++) {
            visited[i] = -1;
        }
        for(int i=0; i<V; i++) {
            if(visited[i] == -1)
                if(!dfs(graph, i, visited))
                    return false;
        }
        return true;
    }

    public boolean dfs(int[][] graph, int node, int[] visited) {
        for(int i=0; i<graph[node].length; i++) {
            if(visited[graph[node][i]] == -1) {
                visited[graph[node][i]] = 1 - visited[node];
                if(!dfs(graph, graph[node][i], visited))
                    return false;
            }
            else if(visited[node] == visited[graph[node][i]])
                return false;

        }
        return true;
    }
}
