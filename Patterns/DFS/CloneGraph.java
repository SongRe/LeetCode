import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    // visited is a map from original -> cloned node
    private HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        // if we have visited this node already, return its cloned version
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        // create the cloned node of this one
        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        // put it in visited
        visited.put(node, cloneNode);
        // fill the cloned node's neighbors
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
    

}