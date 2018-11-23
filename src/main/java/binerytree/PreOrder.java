package binerytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root==null)
            return;
        res.add(root.val);
        if (root.left != null)
            helper(root.left, res);
        if (root.right != null)
            helper(root.right, res);
    }

    //迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur!=null){
                res.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return res;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur!=null){
                str = str + cur.val + "->";
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return str;
    }
}