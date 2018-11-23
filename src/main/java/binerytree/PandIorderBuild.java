package binerytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PandIorderBuild
 * @Description 根据前序遍历和中序遍历构建树
 * @Author mingjie
 * @Date 2018/11/24 12:22 AM
 * @Versrion 1.0
 **/
public class PandIorderBuild {

    private Map<Integer, Integer> map;

    /*
     * @Author mingjie
     * @Description //
     * @Date 12:30 AM 2018/11/24
     * @Param [preorder, inorder]
     * @return binerytree.TreeNode
     **/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        int length = preorder.length;
        map = new HashMap<>(length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, length - 1, inorder, 0, length - 1);
    }

    private TreeNode helper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }
        int mid = map.get(preorder[pl]);
        int count = mid - il;
        TreeNode root = new TreeNode(preorder[pl]);
        root.left = helper(preorder, pl + 1, pl + count, inorder, il, mid - 1);
        root.right = helper(preorder, pl + count + 1, pr, inorder, mid + 1, ir);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        PandIorderBuild pib = new PandIorderBuild();
        TreeNode root = pib.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
