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

    //低柜解法
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        insertOrder(root,list,0);
        return list;
    }

    private void insertOrder(TreeNode root,List<List<Integer>> lists,int i){
        if (root==null){
            return;
        }
        if(lists.size()<i+1){
            lists.add(new ArrayList<>());
        }
        List<Integer> list = lists.get(i);
        list.add(root.val);
        insertOrder(root.left,lists,i+1);
        insertOrder(root.right,lists,i+1);
    }
}








