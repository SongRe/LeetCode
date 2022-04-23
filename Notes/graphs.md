---
title: "Graphs"
tags: ""
---

Graphs
-

Terminology

- Vertex: In Figure 1, nodes such as A, B, and C are called vertices of the graph.
-  Edge: The connection between two vertices are the edges of the graph. In Figure 1, the connection between person A and B is an edge of the graph.
- Path: the sequence of vertices to go through from one vertex to another. In Figure 1, a path from A to C is [A, B, C], or [A, G, B, C], or [A, E, F, D, B, C].
**Note**: there can be multiple paths between two vertices.

- Path Length: the number of edges in a path. In Figure 1, the path lengths from person A to C are 2, 3, and 5, respectively.
Cycle: a path where the starting point and endpoint are the same vertex. In Figure 1, [A, B, D, F, E] forms a cycle. Similarly, [A, G, B] forms another cycle.
- Negative Weight Cycle: In a “weighted graph”, if the sum of the weights of all edges of a cycle is a negative value, it is a negative weight cycle. In Figure 4, the sum of weights is -3.
- Connectivity: if there exists at least one path between two vertices, these two vertices are connected. In Figure 1, A and C are connected because there is at least one path connecting them.
- Degree of a Vertex: the term “degree” applies to unweighted graphs. The degree of a vertex is the number of edges connecting the vertex. In Figure 1, the degree of vertex A is 3 because three edges are connecting it.
- In-Degree: “in-degree” is a concept in directed graphs. If the in-degree of a vertex is d, there are d directional edges incident to the vertex. In Figure 2, A’s indegree is 1, i.e., the edge from F to A.
- Out-Degree: “out-degree” is a concept in directed graphs. If the out-degree of a vertex is d, there are d edges incident from the vertex. In Figure 2, A’s outdegree is 3, i,e, the edges A to B, A to C, and A to G.

Disjoint Set:
-
Main purpose of disjoint set is to address connectivity between vertices of a graph, i.e, whether or not two notes share a common ancestor. 

![image.png](https://boostnote.io/api/teams/xlpda-nfC/files/c1ab38555a08b1bf808df08260bae74cecac64d62cbbbd7c248a58f25b0f4f18-image.png)

- Parent node: a node that is the direct parent of another vertex. 3’s parent node is 1. 2’s parent node is 0, 9 is its own parent node
  - Any node that is its own parent node is called a root node. So, 5,0,4,9 are root nodes. The root node of 3 and 2 is 0.
Basic idea of disjoint set:
![image.png](https://boostnote.io/api/teams/xlpda-nfC/files/483299998230c8f18982c1a76e3bd8dd9f8e12c5f80ae4ffde3588a3b9858436-image.png)


- To ‘connect’ vertices together, we put them in a set. So, (0,1) starts as its own set, then (0,2) sees that 0 is in a set, so we simply put 2 in that set to get a new set, (0,1,2).
- Every time a new set is created, we must designated the head of the set (chosen arbitrarily). This also applies when the merging of multiple sets occurs -  a new head must be chosen.
- Then, to check if two vertices are connected, we simply compare the heads of each respective vertex. If they are equal, then they are part of the same set and are thus connected. 
Implementing Disjoint Set
-

Basic idea is to keep track of a Root Array, where the index i of the array is the value of the vertex, and array[i] = its root node. Initially, arr[i] = i for every entry. (each vertex is its own parent node)
- Union: When creating links, we update the root array appropriately. For example, if we have (0,1) as a connection, then we can choose 0 as parent node and thus arr[0] = 0 and arr[1] = 0.
  - Furthermore, when adding (0,2) as a connection, if we choose 2 as the new head, then we must update accordingly as well. Thus, arr[2] = 2 and arr[0] = 0. If 0 is still our parent, then simply have arr[2] = 0 and arr[0] = 0. (arr[0] does not change)
  - Whenever we add new connections, example, (i, j), we set arr[i] = j, or arr[j] = i. This basically just means that the parent node of i is j, or the parent node of j becomes i. Through the find method, we’ll be able to check connectivity later. 
  - It either chooses one of the nodes to be a root vertex, or makes one of them the other’s parent. Using the parent vertex, we update the root array. 
- Find: Find the root node of a given node. Remember that root nodes are nodes that are their own parent node. In other words, i = arr[i]. So, for find(3) , We check if arr[3] = 3. If it does, then the root node of 3 is 3. Else, we keep searching, so if arr[3] = x, then we search arr[x] until arr[x] = x. Once arr[x] = x, then return x as the root node.
- Checking Connectivity: this is simply just finding the root nodes of two nodes and checking if their root nodes are equal. 
Quick Find:
-

Quick find focuses on O(1) time for find() and a longer time for union.
Root[i] directly stores i’s root node at root[i]. 
```
// UnionFind.class
class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }
		
    
    // change all values with root Y to have a new root X. 
    // this is because we are changing root Y to root X, so any value that had Y as its root before now has X as the root. 
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

// App.java
// Test Case
public class App {
    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
```
Quick Union
-

Quick union is actually more efficient than quick find:
- Find() in quick union will have a worst case scenario O(N) - when all the nodes are like a linked list, whereas quick find always has O(N) union operations. 

```class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    // this time, we must continuously search until we find the root node. 
    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

  // here, we simply choose rootX as the parent node, so root[i] stores i's parent node. 
  // we make rootX rootY's parent node when creating a new union.
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

// App.java
// Test Case
public class App {
    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
```

Union By Rank
-
- Quick Union, but a way to make it so that the set is less likely to be unioned into a straight line
- We do this by ranking trees by their height. The tree with the tallest height will become the root node, and dominate others.
  - Ex: When merging two nodes, 1 and 6, where 1's root node is 0 and 6's root node is 5:
    - We begin by calculating the height of each tree. If 5's height is smaller, set 0 as 5's root node.
    - If 0's height is smaller, set 5 as 0's root node. 

```
class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; 
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
```
- note that there's a rank array as well. We use it to record the height of each vertex.
- Initially, each node is its own parent, so the rank of each node is 1.
- Union method: note that we only unionize nodes that have different roots. 
  - We check for each node's rank, and the node with higher rank maintains its root node, while the one with lower rank has its root node changed. 
  - If they are the same, it doesn't matter, so pick one: then increase that one's rank by 1. (since we are increasing height nmw)
Time Complexity:
- Constructor is in O(N)
- Everything else is in O(log N)

Optimized Path Compression
-
- This is for find(), and specifically for a quick union implementation of disjoint set. 
- When using find(5) in quick union, we travel from 5 -> 4 -> 3 -> 0 (RN) potentially. Basically, we want to make it so that as we travel, we update the root[] array such that the next time we call find(4), find(5) or find(3), it takes us directly to 0. We avoid traversing the same path multiple times through recursion.

```
class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }
    // note that we return the value of root[x], which will be find(root[x]). We update root[x] in the process.
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
```

Optimized disjoint set with both:
- Time Complexity:
- Constructor is O(N)
  - Everything else is O(1) on average, or O($alpha$(N)), where $alpha$ is the inverse-ackermann function
- Space Complexity
  - O(N)
