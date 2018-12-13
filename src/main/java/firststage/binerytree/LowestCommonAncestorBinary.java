package firststage.binerytree;

/**
 * @ClassName LowestCommonAncestorBinary
 * @Description 二叉搜索树的最近公共祖先
 * @Author mingjie
 * @Date 2018/12/3 11:45 PM
 * @Versrion 1.0
 **/
public class LowestCommonAncestorBinary {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        if((root.val>p.val&&root.val<q.val)||(root.val<p.val&&root.val>q.val)){
            return root;
        }
        if (root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return lowestCommonAncestor(root.right,p,q);
        }
    }

}
