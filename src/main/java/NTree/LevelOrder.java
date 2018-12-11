package NTree;

import java.util.*;

/**
 * @ClassName LevelOrder
 * @Description N叉树的层序遍历
 * @Author mingjie
 * @Date 2018/12/12 12:18 AM
 * @Versrion 1.0
 **/
public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Node> temp = null;
        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                list.add(cur.val);
                for (Node node:cur.children){
                    temp.offer(node);
                }
            }
            if (temp.size() > 0) {
                queue = temp;
                temp = null;
            }
            lists.add(list);
        }
        return lists;
    }
}
