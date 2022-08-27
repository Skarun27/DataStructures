package Topics.Graphs.DisjointSet;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestMoment {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            public int compare(int[] log1, int[] log2) {
                Integer time1 = new Integer(log1[0]);
                Integer time2 = new Integer(log2[0]);
                return time1.compareTo(time2);
            }
        });
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<logs.length; i++) {
            uf.union(logs[i][0], logs[i][1], logs[i][2]);
        }
        if(uf.getCount() == 1)
            return uf.getEarliestTime();
        else return -1;
    }
}

class UnionFind{
    
    int[] root;
    int[] rank;
    int count;
    int earliestTime = 0;
    
    public UnionFind(int size) {
        this.root = new int[size];
        this.rank = new int[size];
        count = size;
        for(int i=0; i<size; i++) {
            root[i] = i;
            rank[i] = -1;
        }
    }
    
    public int find(int x) {
        if(root[x] == x)
            return x;
        return root[x] = find(root[x]);
    }
    
    public void union(int time, int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            }
            else if(rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            }
            else {
                root[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }
            count--;
            earliestTime = time;
        }
    }
    
    public int getEarliestTime() {
        return earliestTime;
    }
    
    public int getCount() {
        return count;
    }
}
