package binerytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Codec
 * @Description 二叉树的序列化与反序列化
 * @Author mingjie
 * @Date 2018/11/26 11:30 PM
 * @Versrion 1.0
 **/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> helper = new LinkedList<>();
        Queue<TreeNode> temp = null;
        queue.offer(root);
        String str = "";
        while (!queue.isEmpty()){
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                if (cur==null){
                    helper.offer(null);
                    helper.offer(null);
                    str=str+"null,null,";
                }else {
                    helper.offer(cur.left);
                    helper.offer(cur.right);
                    str=str+cur.left+","+cur.right+",";
                }
            }
            str = str.substring(0,str.length()-1)+"|";
            temp = queue;
            queue = helper;
            helper = temp;
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0){
            return null;
        }
        String[] rows = data.split("|");
        TreeNode root = new TreeNode(Integer.valueOf(rows[0]));
        if(rows.length==1){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1;i<rows.length;i++){
            String[] cols = rows[i].split(",");
            TreeNode cur = queue.poll();
            for (int j=0;j<cols.length;j++){
                TreeNode newnode = null;
                if(!cols[j].equals("null")){
                    newnode = new TreeNode(Integer.valueOf(cols[j]));
                }
            }
        }
        return root;
    }
}
