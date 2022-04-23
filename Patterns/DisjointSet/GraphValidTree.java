public class GraphValidTree {
    
}

class Solution {
    int[] root;
    int[] rank;
    
    public int find(int a) {
        if (root[a] == a) {
            return a;
        }
        return find(root[a]);
    }
    
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
            } else if (rank[rootB] > rank[rootA]) {
                root[rootA] = rootB;
            } else {
                root[rootB] = root[rootA];
                rank[rootA]++;
            }
        } else {
            return false; //we are performing a union op on two nodes that are already connected, thus circle and therefore not tree
        }
        return true;

    }
    
    public boolean validTree(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];
        if (edges.length != n - 1) return false;
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        
        for (int i = 0; i < edges.length; i++) {
            if(!union(edges[i][0], edges[i][1])) return false;
        }
       
        return true;
    }
}
