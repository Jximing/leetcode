package binerytree;

/**
 * @ClassName InsertIntoBST
 * @Description Insert into a Binary Search Tree
 * @Author mingjie
 * @Date 2018/12/4 11:46 PM
 * @Versrion 1.0
 **/
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.left = insertIntoBST(root.left,val);
        }
        if(root.val<val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }

}
