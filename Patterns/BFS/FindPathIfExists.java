class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!neighbors.containsKey(edges[i][0])) {
                neighbors.put(edges[i][0], new HashSet<Integer>());
            }
            if (!neighbors.containsKey(edges[i][1])) {
                neighbors.put(edges[i][1], new HashSet<Integer>());
            }
            neighbors.get(edges[i][0]).add(edges[i][1]);
            neighbors.get(edges[i][1]).add(edges[i][0]);
        }
        queue.add(source);
        while (!queue.isEmpty()) {
            int cur = queue.pop();
            visited.add(cur);
            if (cur == destination) return true;
            HashSet<Integer> neighbor = neighbors.get(cur);
            for (int i : neighbor) {
                if (!visited.contains(i)) {
                    queue.add(i);
                }
            }
        }
        return false;
    }
}
