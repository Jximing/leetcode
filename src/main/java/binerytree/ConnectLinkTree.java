package binerytree;

/**
 * @ClassName ConnectLinkTree
 * @Description 每个节点的右向指针
 * @Author mingjie
 * @Date 2018/11/24 2:49 PM
 * @Versrion 1.0
 **/
public class ConnectLinkTree {

    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        TreeLinkNode temp = root.left;
        while (root!=null){
            root.left.next = root.right;
            TreeLinkNode right = root.right;
            root = root.next;
            if(root==null){
                right.next = root;
            }else {
                right.next = root.left;
            }
        }
        connect(temp);
    }
}


class TreeLinkNode {

    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}