package Topics.Graphs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    HashMap<Node, Node> isVisited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        
        if(node == null) {
            return null;
        }
        
        if(isVisited.containsKey(node)) {
            return isVisited.get(node);
        }
        
        Node cloneNode = new Node(node.val, new ArrayList<>());
        isVisited.put(node, cloneNode);
        
        for(Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
