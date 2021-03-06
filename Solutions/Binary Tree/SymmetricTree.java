class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    
    boolean check(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1==null || r2 == null) return false;
        if (r1.val == r2.val) { 
            return check(r1.right, r2.left) && check(r1.left, r2.right);
        }
        return false;
    }
    
}
