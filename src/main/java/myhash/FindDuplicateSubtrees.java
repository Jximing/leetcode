package myhash;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (root == null){
            return list;
        }
        find(root, new HashMap<String, Integer>(), list);
        return list;
    }

    private String find(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
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

    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<Long, Integer> id =  new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, id, map, res);
        return res;
    }

    private Integer helper(TreeNode root, Map<Long, Integer> id, Map<Integer, Integer> map, List<TreeNode> res) {
        if (root == null) return 0;
        Long key = ((long) root.val << 32) | helper(root.left, id, map, res) << 16 | helper(root.right, id, map, res);
        if (!id.containsKey(key))
            id.put(key, id.size() + 1);
        int curId = id.get(key);
        if (map.containsKey(curId)) {
            if (map.get(curId) == 1) res.add(root);
            map.put(curId, map.get(curId) + 1);
        }
        else map.put(curId, 1);
        return curId;
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