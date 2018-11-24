package binerytree;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LowestCommonAncestor
 * @Description 二叉树的最近公共祖先
 * @Author mingjie
 * @Date 2018/11/25 1:21 AM
 * @Versrion 1.0
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        //查看左子树中是否有目标结点，没有为null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //查看右子树是否有目标节点，没有为null
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //都不为空，说明左右子树都有目标结点，则公共祖先就是本身
        if (left != null&&right != null)
            return root;
        //如果发现了目标节点，则继续向上标记为该目标节点
        return left == null ? right : left;
    }


    @Test
    public void dequeuetest(){
        Deque<Integer> dq = new LinkedList<>();
        dq.push(1);
        dq.push(2);
        dq.push(3);
        dq.push(4);
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());
    }
}
