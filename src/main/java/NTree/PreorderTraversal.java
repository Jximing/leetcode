package NTree;

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
        return null;
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