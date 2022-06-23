package Practice.Graphs.DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSource {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<Integer>();
        currPath.add(0);
        pathRec(graph, paths, currPath, 0);
        return paths;
    }
    
    public void pathRec(int[][] graph, List<List<Integer>> paths, List<Integer> currPath, int val) {
        if(val == graph.length -1) {
            paths.add(new ArrayList<>(currPath));
            return;
        }
        for(int node: graph[val]) {
            currPath.add(node);
            pathRec(graph, paths, currPath, node);
            currPath.remove(currPath.size()-1);
        }
    }
}
