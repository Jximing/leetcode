package NTree;

import java.util.ArrayList;
import java.util.List;

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