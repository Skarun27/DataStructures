package SDESheet.Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MSTusingPrimsAlgo {
    static class Node implements Comparator<Node> {
        int val;
        int weight;
        Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
        Node() {}
        public int getV() {
            return val;
        }
        public int getWeight() {
            return weight;
        }
        public int compare(Node node1, Node node2) {
            if(node1.weight < node2.weight) {
                return -1;
            }
            if(node1.weight > node2.weight) {
                return 1;
            }
            return 0;
        }
    }

    static void primsAlgo(int N, ArrayList<ArrayList<Node>> adj) {
        int[] dist = new int[N];
        int[] parent = new int[N];
        boolean[] mst = new boolean[N];

        for(int i=0; i<N; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        dist[0] = 0;
        pq.add(new Node(0, dist[0]));

        for(int i=0; i<N-1; i++) {
            int vertice = pq.remove().getV();
            mst[vertice] = true;
            for(Node it: adj.get(vertice)) {
                if(mst[it.getV()] == false && dist[it.getV()] > it.getWeight()) {
                    dist[it.getV()] = it.getWeight();
                    parent[it.getV()] = vertice;
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }

        for(int i=1; i<N-1; i++) {
            System.out.println(parent[i] + "->" + i);
        }
    }

    public static void main(String args[]) {
        int n = 5;
        ArrayList < ArrayList < Node > > adj = new ArrayList < ArrayList < Node > > ();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList < Node > ());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        primsAlgo(n, adj);

    }

}
