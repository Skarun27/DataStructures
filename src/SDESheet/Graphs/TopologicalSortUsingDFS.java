package SDESheet.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortUsingDFS {
    static int count = 0;
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        count = V-1;
        boolean[] visited = new boolean[V];
        int[] arr = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++) {
            if(!visited[i])
                dfs(i, adj, arr, visited);
        }
        return arr;
    }

    static void dfs(int curr, ArrayList<ArrayList<Integer>> adj,
                    int[] arr, boolean[] visited) {
        visited[curr] = true;
        for(Integer val: adj.get(curr)) {
            if(!visited[val])
                dfs(val, adj, arr, visited);
        }
        arr[count--] = curr;
    }

    public static void main(String[] args) {
        int V= 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);

        //Vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        graph.add(neighbors);

        //Vertex - 1
        neighbors = new ArrayList<Integer>();
        neighbors.add(3);
        graph.add(neighbors);

        //Vertex - 2
        neighbors = new ArrayList<Integer>();
        neighbors.add(3);
        graph.add(neighbors);

        //Vertex - 3
        neighbors = new ArrayList<Integer>();
        graph.add(neighbors);

        //Vertex - 4
        neighbors = new ArrayList<Integer>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 5
        neighbors = new ArrayList<Integer>();
        neighbors.add(0);
        neighbors.add(2);
        graph.add(neighbors);

        int[] arr = topoSort(V, graph);
        for(int i=0; i<V; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
