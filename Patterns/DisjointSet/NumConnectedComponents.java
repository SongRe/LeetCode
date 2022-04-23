public class NumConnectedComponents {
    
}

class Solution {
    int[] root;
    int[] rank;
    
    public int find(int a) {
        if(root[a] == a) {
            return a;
        }
        return root[a] = find(root[a]);
    }
    
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            // then this is merging of two components, so reduce count by 1
            if(rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                root[rootA] = rootB;
            } else {
                root[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        } 
        return false;
    }
    public int countComponents(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        int count = n; // at first we have n individual components
        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1])) {
                count--;
            }
        }
        return count;
    }
}
