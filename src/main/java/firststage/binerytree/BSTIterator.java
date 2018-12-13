package firststage.binerytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BSTIterator
 * @Description  二叉搜索树迭代器
 * @Author mingjie
 * @Date 2018/11/28 1:21 AM
 * @Versrion 1.0
 **/
public class BSTIterator {

    private List<Integer> order = new ArrayList<>();

    private int size;

    private int cur;
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                order.add(root.val);
                root = root.right;
            }
        }
        size = order.size();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur<size;
    }

    /** @return the next smallest number */
    public int next() {
        return order.get(cur++);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
