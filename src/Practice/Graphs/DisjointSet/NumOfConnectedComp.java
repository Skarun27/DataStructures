//package Practice.Graphs.DisjointSet;
//
//public class NumOfConnectedComp {
//    public int countComponents(int n, int[][] edges) {
//        UnionFind uf = new UnionFind(n);
//        for(int i=0; i<edges.length; i++) {
//            uf.union(edges[i][0], edges[i][1]);
//        }
//        return uf.getCount();
//    }
//}
//
//class UnionFind{
//
//    int[] root;
//    int[] rank;
//    int count;
//
//    public UnionFind(int size) {
//        this.root = new int[size];
//        this.rank = new int[size];
//        count = size;
//        for(int i=0; i<size; i++) {
//            root[i] = i;
//            rank[i] = -1;
//        }
//    }
//
//    public int find(int x) {
//        if(root[x] == x)
//            return x;
//        return root[x] = find(root[x]);
//    }
//
//    public void union(int x, int y) {
//        int rootX = find(x);
//        int rootY = find(y);
//        if(rootX != rootY) {
//            if(rank[rootX] > rank[rootY]) {
//                root[rootY] = rootX;
//            }
//            else if(rank[rootX] < rank[rootY]) {
//                root[rootX] = rootY;
//            }
//            else {
//                root[rootY] = rootX;
//                rank[rootX] += rank[rootY];
//            }
//            count--;
//        }
//    }
//
//    public int getCount() {
//        return count;
//    }
//}
