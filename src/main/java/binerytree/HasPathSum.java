package binerytree;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root,0,sum);
    }

    private boolean helper(TreeNode root, int sum, int target) {
        if(root==null){
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum + root.val == target;
        }
        sum += root.val;
        return helper(root.left, sum, target)||helper(root.right,sum,target);
    }

}
