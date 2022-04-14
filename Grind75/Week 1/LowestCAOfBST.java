public class LowestCAOfBST {

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


// I forgot BSTs are ordered 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p,q);
        }
        
        return root;
    }
}
