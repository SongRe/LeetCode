package Patterns.Graph;

public class NumProvinces {
    
}

class Solution {
    
    int root[];
    int rank[];

    public void init (int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find (int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union (int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean connected (int x, int y) {
        return find(x) == find(y);
    }
    public int findCircleNum(int[][] isConnected) {
        int numProvinces = 0;
        init(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        // count the roots
        HashSet<Integer> root = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            int r = find(i);
            if (!root.contains(r)) {
                numProvinces++;
                root.add(r);
            }
        }
        return numProvinces;
    }
    





}