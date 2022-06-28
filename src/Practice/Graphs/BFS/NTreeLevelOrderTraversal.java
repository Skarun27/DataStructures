package Practice.Graphs.BFS;
import java.util.*;

public class NTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        
        Queue<Node> nodeQ = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null) return traversal;
        nodeQ.add(root);
        traversal.add(new ArrayList<>());
        traversal.get(0).add(root.val);
        traversal = bfs(traversal, nodeQ);
        return traversal;
    }
    
    public List<List<Integer>> bfs(List<List<Integer>> traversal, Queue<Node> nodeQ) {
        
        while(!nodeQ.isEmpty()) {
            
            List<Integer> nodeVal = new ArrayList<>();
            int size = nodeQ.size();
            for(int i=0; i<size; i++) {
                
                Node node = nodeQ.remove();
                List<Node> adjNodes = new ArrayList<>(node.children);
                for(int j=0; j<adjNodes.size(); j++) {
                    nodeVal.add(adjNodes.get(j).val);
                    nodeQ.add(adjNodes.get(j));
                }
            }
            if(nodeVal.size()>0)
                traversal.add(new ArrayList<>(nodeVal));
        }
        return traversal;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
