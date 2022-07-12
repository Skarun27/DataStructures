package Practice.Graphs.DisjointSet;

public class RedundantConnection {
    
    public int[] findRedundantConnection(int[][] edges) {
        
        DSU dsu = new DSU(edges.length);
        int[] redEdge = new int[2];
        for(int i=0; i<edges.length; i++) {
            
            int x = edges[i][0];
            int y = edges[i][1];
            if(!dsu.isConnected(x, y)) {
                if(!dsu.union(x, y))
                    redEdge = edges[i];
            }
            else
                redEdge = edges[i];
        }
        return redEdge;
    }
}
    
class DSU {
    
    int[] root;
    int[] rank;
    
    public DSU(int size) {
        root = new int[size+1];
        rank = new int[size+1];
        for(int i=0; i<=size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x) {
        if(root[x] == x)
            return x;
        return root[x] = find(root[x]);
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY])
                root[rootY] = rootX;  
            else if(rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
        else return false;
        return true;
    }
    
    public boolean isConnected(int x, int y) {
        return root[x] == root[y];
    }
}
