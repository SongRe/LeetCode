public class TreeHasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(targetSum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean leftResult = false;
        boolean rightResult = false;
        if(root.left != null) {
            leftResult = hasPathSum(root.left, targetSum - root.val);
        }
        if(root.right != null) {
            rightResult =  hasPathSum(root.right, targetSum - root.val);
        }
        if(leftResult || rightResult) {
            return leftResult || rightResult;
        }
        return false;
        
    }
}


