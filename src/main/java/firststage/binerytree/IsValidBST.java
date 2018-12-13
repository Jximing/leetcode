package firststage.binerytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName IsValidBST
 * @Description 验证二叉搜索树
 * @Author mingjie
 * @Date 2018/11/28 12:47 AM
 * @Versrion 1.0
 **/
public class IsValidBST {

    /*
     * @Author mingjie
     * @Description //利用中序遍历后比较
     * @Date 1:15 AM 2018/11/28
     * @Param [root]
     * @return boolean
     **/
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
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
        int pre = list.get(0);
        for (int i=1;i<list.size();i++){
            int cur = list.get(i);
            if(cur<=pre){
                return false;
            }
            pre = cur;
        }
        return true;
    }

    /*
     * @Author mingjie
     * @Description //递归的解法
     * @Date 1:16 AM 2018/11/28
     * @Param [root]
     * @return boolean
     **/
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long min,long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}
