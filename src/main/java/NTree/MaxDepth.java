package NTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName MaxDepth
 * @Description Maximum Depth of N-ary Tree
 * @Author mingjie
 * @Date 2018/12/12 10:46 PM
 * @Versrion 1.0
 **/
public class MaxDepth {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int res = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            res++;
            for (int i = 0; i < levelNum; i++) {
                Node tmp = queue.poll();
                if (tmp.children != null) {
                    List<Node> child = tmp.children;
                    for (Node ele : child) queue.add(ele);
                }
            }
        }
        return res;
    }

    /**
     * @Author mingjie
     * @Description 递归解法
     * @Date 10:55 PM 2018/12/12
     * @Param [root]
     * @return int
     **/
    public int maxDepth1(Node root) {
        if(root == null)
            return 0;
        int x = 0;
        for(int i = 0;i<root.children.size();i++){
            x = Math.max(x,maxDepth1(root.children.get(i)));
        }
        return x+1;
    }

}
