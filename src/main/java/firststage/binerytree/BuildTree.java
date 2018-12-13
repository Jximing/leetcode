package firststage.binerytree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if (il > ir || pl > pr) {
            return null;
        }
        int mid = map.get(postorder[pr]);
        int count = mid - il;
        TreeNode root = new TreeNode(postorder[pr]);
        root.left = buildTree(inorder, il, mid - 1, postorder, pl, pl + count - 1);
        root.right = buildTree(inorder, mid + 1, ir, postorder, pl + count, pr - 1);
        return root;
    }

}
