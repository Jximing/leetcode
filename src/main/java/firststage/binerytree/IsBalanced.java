package firststage.binerytree;

/**
 * @ClassName IsBalanced
 * @Description 平衡二叉树
 * @Author jxm
 * @Date 2018/12/7 22:27
 * @Version 1.0
 **/
public class IsBalanced {

    /**
     * @return
     * @Author jxm
     * @Description //TODO
     * @Date 22:27 2018/12/7
     * @Param
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(helper(root.left) - helper(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(helper(root.left), helper(root.right));
    }

    /**
     * better method
     * @return boolean
     * @Author jxm
     * @Description //TODO
     * @Date 22:47 2018/12/7
     * @Param [root]
     **/
    public boolean isBalanced1(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;

        int left = depth(root.left);
        if (left == -1)
            return -1;
        int right = depth(root.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }

}
