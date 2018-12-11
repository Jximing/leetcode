package NTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PostorderTraversal
 * @Description 给定一个 N 叉树，返回其节点值的后序遍历。
 * @Author mingjie
 * @Date 2018/12/10 9:07 PM
 * @Versrion 1.0
 **/
public class PostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    private void helper(Node root,List<Integer> list){
        if (root==null){
            return;
        }
        for (Node node:root.children){
            helper(node,list);
        }
        list.add(root.val);
    }

    public List<Integer> postorder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node pre = null;
        while(!stack.isEmpty()){
            Node cur = stack.peek();
            if(cur.children.size()==0 ||(pre!=null&&cur.children.contains(pre))){
                ans.add(cur.val);
                pre = cur;
                stack.pop();
            }
            else
                for(int i= cur.children.size()-1;i>=0;i--){
                    stack.push(cur.children.get(i));
                }
        }
        return ans;
    }

}
