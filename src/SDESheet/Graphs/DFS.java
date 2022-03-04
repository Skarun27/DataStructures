package SDESheet.Graphs;

import java.util.ArrayList;

public class DFS {
    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs){
        storeDfs.add(node);
        vis[node] = true;
        for(Integer it:adj.get(node)){
            if(vis[it] == false){
                dfs(it,vis,adj,storeDfs);
            }
        }
        return;
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V+1];
        ArrayList<Integer> storeDfs = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                dfs(i,vis,adj,storeDfs);
            }
        }
        return storeDfs;
    }
}
