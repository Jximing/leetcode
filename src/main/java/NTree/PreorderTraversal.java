package NTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PreorderTraversal
 * @Description TODO
 * @Author mingjie
 * @Date 2018/12/9 11:52 PM
 * @Versrion 1.0
 **/
public class PreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(Node root,List<Integer> list){
        if (root==null){
            return;
        }
        list.add(root.val);
        if(root.children!=null&&!root.children.isEmpty()){
            for (Node node:root.children){
                helper(node,list);
            }
        }
    }
    /**
     * @Author mingjie
     * @Description //递归方法2
     * @Date 12:12 AM 2018/12/10
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        list.add(root.val);
        if(root.children!=null){
            for(Node node:root.children){
                List<Integer> list2 = preorder1(node);
                list.addAll(list2);
            }
        }
        return list;
    }

    /**
     * @Author mingjie
     * @Description //迭代方法
     * @Date 12:12 AM 2018/12/10
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     **/
    public List<Integer> preorder2(Node root) {
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            result.add(cur.val);
            if(cur.children!=null){
                for(int i=cur.children.size()-1;i>=0;i--){
                    stack.push(cur.children.get(i));
                }
            }
        }
        return result;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}