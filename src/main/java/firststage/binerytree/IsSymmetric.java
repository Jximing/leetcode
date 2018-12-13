package firststage.binerytree;


public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetrical(root.left, root.right);
    }
    //比较左右子树对应节点是否相同
    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null)
            return true;
        if (pRoot1 == null || pRoot2 == null)
            return false;
        if (pRoot1.val != pRoot2.val)
            return false;
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}
