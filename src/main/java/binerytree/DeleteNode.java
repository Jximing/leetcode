package binerytree;

/**
 * @ClassName DeleteNode
 * @Description Delete Node in a BST
 * @Author jxm
 * @Date 2018/12/1 18:05
 * @Version 1.0
 **/
public class DeleteNode {

    /*
     * @Author jxm
     * @Description 递归解法
     * @Date 18:22 2018/12/1
     * @Param
     * @return
     **/
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val>key){
            root.left =deleteNode(root.left,key);
        }else if(root.val<key){
            root.right =deleteNode(root.right,key);
        }else {
            if(root.left==null){
                return root.right;
            }else if(root.right ==null){
                return root.left;
            }
            TreeNode cur = root.right;
            while (cur.left!=null){
                cur = cur.left;
            }
            root.val = cur.val;
            root.right = deleteNode(root.right,cur.val);

        }
        return root;
    }

    public static void main(String[] args){
        DeleteNode dn = new DeleteNode();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(dn.deleteNode(root,2));
    }

}
