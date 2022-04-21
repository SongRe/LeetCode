package Data Structure Templates;

public class DisjointSet {
    int root[];
    int rank[];

    public DisjointSet (int size) {
        root = new int[size];
        rank = new int[size];
        for (int i : root) {
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
}

public class UnionFind {
    // Constructor of Union-find. The size is the length of the root array.
    int root[];
    int rank[];
    public UnionFind(int size) {}
    public int find(int x) {}
    public void union(int x, int y) {}
    public boolean connected(int x, int y) {}
}
