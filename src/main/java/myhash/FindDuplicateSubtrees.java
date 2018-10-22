package myhash;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (root == null){
            return list;
        }
        find(root, new HashMap<String, Integer>(), list);
        return list;
    }

    public String find(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
        if (root == null){
            return "#";
        }
        String str = root.val + "," + find(root.left, map, list) + "," + find(root.right, map, list);
        if (map.getOrDefault(str, 0) == 1){
            list.add(root);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}