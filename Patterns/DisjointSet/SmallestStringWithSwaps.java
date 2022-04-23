class Solution {
    int root[];
    int rank[];
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // initialize the disjoint set
        root = new int[s.length()];
        rank = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            root[i] = i;
            rank[i] = 1;
        }
        
        for (int i = 0; i < pairs.size(); i++) {
            union(pairs.get(i).get(0), pairs.get(i).get(1));
        }
        
        /**
        After this we will have groups where we see which indexes of the string are "connected", or swappable. We don't care about what swaps we do, we just know that there is an amount of swaps that we can get so that it is lexicographically smallest
        */
        char[] answer = new char[s.length()];
        HashMap<Integer, List<Integer>> strings = new HashMap<>(); // integer is the root index, string is the chars that are connected to it
        for (int i = 0; i < root.length; i++) {
            int curRoot = find(i);
            strings.putIfAbsent(curRoot, new ArrayList<>());
            strings.get(curRoot).add(i); //add this index to the list of indexes that are a part of this collection 
        }
        
        // now we look at each group of indices
        for (List<Integer> indices : strings.values()) {
            List<Character> str = new ArrayList<>();
            for(Integer i : indices) {
                str.add(s.charAt(i));
            }
            Collections.sort(str);
            // construct it's respective string and sort it
            

            // map them back to the original answer. str.get(i) will give them the newly sorted, updated char and indices.get(i) gives them it's original index. 
            for (int i = 0; i < indices.size(); i++) {
                answer[indices.get(i)] = str.get(i);
            }
        }
        
        return new String(answer);
        

    }
    
    public int find (int a) {
        if (a == root[a]) {
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
                    root[rootB] = rootA;
                    rank[rootA]++;
                }
            }
        }
}
