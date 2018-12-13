package firststage.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    /**
     * 中序遍历，采用递归方法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(MyTreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(list, root);
        return list;
    }

    public void traversal(List<Integer> list, MyTreeNode root) {
        if (root == null) {
            return;
        }
        traversal(list, root.left);
        list.add(root.val);
        traversal(list, root.right);
    }

    /**
     * 不用递归实现
     */
    public List<Integer> inorderTraversal1(MyTreeNode root) {
        Stack<MyTreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}





class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;

    MyTreeNode(int x) {
        val = x;
    }
}