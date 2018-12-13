package firststage.binerytree;

/**
 * @ClassName ConnectLinkTree
 * @Description 每个节点的右向指针
 * @Author mingjie
 * @Date 2018/11/24 2:49 PM
 * @Versrion 1.0
 **/
public class ConnectLinkTree {

    /*
     * @Author mingjie
     * @Description //递归解法
     * @Date 3:04 PM 2018/11/24
     * @Param [root]
     * @return void
     **/
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

    /*
     * @Author mingjie
     * @Description //迭代解法
     * @Date 3:03 PM 2018/11/24
     * @Param [root]
     * @return void
     **/
    public void connect1(TreeLinkNode root) {
        TreeLinkNode head = new TreeLinkNode(0);
        TreeLinkNode tail = head;

        TreeLinkNode current = root;

        while (current != null) {
            // 左右节点入队
            if (current.left != null) {
                tail = tail.next = current.left;
            }

            if (current.right != null) {
                tail = tail.next = current.right;
            }

            // 一个节点出队
            current = current.next;

            // head和tail指向下一行，current指向当前行
            if (current == null) {
                current = head.next;
                tail = head;
                head.next = null;
            }
        }
    }
}


class TreeLinkNode {

    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}