public class InvertTree {
    
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode temp = root.right;
        TreeNode tempLeft = root.left;
        if (root.left != null) {
            root.right = invertTree(root.left);
            root.left = null;
        }
        
        if (temp != null) {
            if (tempLeft == null) {
                root.right = null;
            }
            root.left = invertTree(temp);
        }
        return root;
    }
}
