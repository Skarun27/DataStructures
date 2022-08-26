package Practice.Graphs.DisjointSet;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if(!uf.union(edges[i][0], edges[i][1]))
                return false;
        }
        return true;
    }
    
    class UnionFind {
        private int[] root;
        private int[] rank;

        UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY)
                return false;
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                    rank[rootY] += rank[rootX];
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += rank[rootY];
                }
            }
            return true;
        }
    }
}
