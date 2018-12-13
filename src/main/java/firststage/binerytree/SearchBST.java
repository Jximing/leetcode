package firststage.binerytree;

/**
 * @ClassName SearchBST
 * @Description Search in a Binary Search Tree
 * @Author mingjie
 * @Date 2018/11/29 12:22 AM
 * @Versrion 1.0
 **/
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        while (root!=null&&root.val!=val){
            if(root.val>val){
                root=root.left;
            }else if(root.val<val){
                root = root.right;
            }
        }
        return root;
    }

}
