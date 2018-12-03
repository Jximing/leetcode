package binerytree;

/**
 * @ClassName LowestCommonAncestorBinary
 * @Description 二叉搜索树的最近公共祖先
 * @Author mingjie
 * @Date 2018/12/3 11:45 PM
 * @Versrion 1.0
 **/
public class LowestCommonAncestorBinary {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root.val>p.val&&root.val>q.val){
            root = root.left;
        }
        while (root.val<p.val&&root.val<q.val){
            root = root.right;
        }
        return root;
    }

}
