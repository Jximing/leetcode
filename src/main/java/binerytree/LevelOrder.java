package binerytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LevelOrder
 * @Description TODO
 * @Author jxm
 * @Date 2018/11/17 22:28
 * @Version 1.0
 **/
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> helper = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                sublist.add(cur.val);
                if(cur.left!=null){
                    helper.offer(cur.left);
                }
                if(cur.right!=null){
                    helper.offer(cur.right);
                }
            }
            list.add(sublist);
            Queue<TreeNode> temp = queue;
            queue = helper;
            helper = temp;
        }
        return list;
    }
}
