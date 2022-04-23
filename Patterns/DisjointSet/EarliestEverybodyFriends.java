public class EarliestEverybodyFriends {
    
}

class Solution {
    int root[];
    int rank[];
    int unfriendly;
    
    public int find(int a) {
        if (root[a] == a) {
            return a;
        }
        return root[a] = find(root[a]); //path compression - normal is just return find(root[a]);
    }
    
    public void union (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) { //only union friends that aren't already friends
            if (rank[rootA] > rank[rootB]) {
                root[rootB] = rootA;
                //unfriendly -= rank[rootB]; // the height of 
            } else if (rank[rootB] > rank[rootA]) {
                root[rootA] = rootB;
            } else {
                root[rootB] = rootA;
                rank[rootA]++; 
            }
            
        }
    }
    
    
    public int earliestAcq(int[][] logs, int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        unfriendly = n; 
        Arrays.sort(logs, new Comparator<int[]>() {
            public int compare (int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int i = 0; i < logs.length; i++) {
            union(logs[i][1], logs[i][2]);
            // System.out.println("after union: " + logs[i][1] + " and " + logs[i][2]);
            // for (int j = 0; j < root.length; j++) {
            //     System.out.println(root[j] + " " + j);
            // }
            if (checkSame(root)) {
                return logs[i][0];
            }
        }
        return -1;
        
    }
    
    public boolean checkSame(int[] root) {
        if (root.length <= 1) return true;
        for(int i = 1; i < root.length; i++) {
            if (find(root[i]) != find(root[i - 1])) {
                return false;
            }
        }
        return true;
        
    }
}

// we use a disjoint set to keep track of friend groups, and who is in what set. We have a brute force checkSam() method that will iterate through root and return true if all calls to find(i) where i in root are the same.
// It is important that we sort the original logs array by timestamp, which is what we do in the Arrays.sort(), by overriding its comparator. 
