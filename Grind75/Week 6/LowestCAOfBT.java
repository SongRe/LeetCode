package Grind75.Week 6;

public class LowestCAOfBT {
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Initial Solution
// TLE, but correct
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (contains(root.left, p) && contains(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (contains(root.right, p) && contains(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    public boolean contains(TreeNode root, TreeNode s) {
        if (root == null) return false;
        if (root.val == s.val) return true;
        return contains(root.left, s) || contains(root.right, s);
    }
}

// Non TLE solution    
class Solution {

    private TreeNode ans;

    public Solution() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Squashed solution
class Solution {
    TreeNode answer;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root, p, q);
        return answer;
    }
    
    public boolean recurse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int left = recurse(root.left, p, q) ? 1 : 0; // if we find any of p or q in the left
        int right = recurse(root.right, p, q) ? 1 : 0; // if we find either p or q in the right
        int mid = (root == p || root == q) ? 1 : 0; // if our current node is either p or q
        
        if (left + mid + right >= 2) {
            // then we have found our answer
            answer = root; // then at this root, we have found all nodes 
        }
        return (left + mid + right > 0); // return whether or not we have found any of p or q
    }
}
