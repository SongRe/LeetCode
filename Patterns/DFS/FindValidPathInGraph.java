package Patterns.DFS;

public class FindValidPathInGraph {
    
}

/*
Algorithm:
-------------------------------------------------------------------------------------
1. Construct a bi-directional graph from the given array of edges.
2. Perform DFS from the given `source`.
3. Maintain a `visited` array to keep a track of visited nodes.
4. Return `True` and get out of the recursion call once target is reached. If target
   is not reached and all possible nodes which can be gone from the `source` node
   are visited return `False`.
-------------------------------------------------------------------------------------
*/

class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> vis;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        map = new HashMap<>();
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            map.putIfAbsent(u, new ArrayList<Integer>());
            map.putIfAbsent(v, new ArrayList<Integer>());
            map.get(v).add(u);
            map.get(u).add(v);
        }
        vis = new HashSet<Integer>();
        return dfs(source, destination);
    }


    public boolean dfs(int u, int target){
        if(u == target)
            return true;
        vis.add(u); //this node is now visited
        for(int v : map.get(u)){ // for every path from u, if v is not visited and dfs of v is true
            if(!vis.contains(v) && dfs(v, target))
                return true;
        }
        return false;
    }
}

// using disjoint set algorithm
class Solution {
    int root[];
    int rank[];
    
    public int find(int a) {
        if (root[a] == a) {
            return a;
        }
        return root[a] = find(root[a]);
    }
    
    public void union (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
            } else if (rank[rootB] > rank[rootA]) {
                root[rootA] = rootB;
            } else {
                root[rootA] = rootB;
                rank[rootB] ++;
            }
        }

    }
    
    public boolean isConnected (int a, int b) {
        return find(a) == find(b);
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0], edges[i][1]);
        }
        
        return isConnected(source, destination);
    }
}