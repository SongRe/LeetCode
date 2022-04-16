public class BalancedBT {
    
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


 // if the left and right heights are balanced, we want to keep checking if the child nodes are balanced
 // if that doesn't return true, then it can't be balanced
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } 
        return false;
    }
    
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
