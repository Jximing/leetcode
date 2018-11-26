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
        String str = root.val+"|";
        while (!queue.isEmpty()){
            String row = "";
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                if (cur==null){
                    helper.offer(null);
                    helper.offer(null);
                    row=row+"null,null,";
                }else {
                    helper.offer(cur.left);
                    helper.offer(cur.right);

                    row=row+(cur.left==null?"null":cur.left.val)
                            +","+(cur.right==null?"null":cur.right.val)+",";
                }
            }
            if(row.replaceAll("null,","").equals("")){
                break;
            }
            str = str + row.substring(0,row.length()-1)+"|";
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
        String[] rows = data.split("\\|");
        TreeNode root = new TreeNode(Integer.valueOf(rows[0]));
        if(rows.length==1){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;
        for (int i = 1;i<rows.length;i++){
            String[] cols = rows[i].split(",");
            cur = queue.poll();
            for (int j=0;j<cols.length;j++){
                TreeNode newnode = null;
                if(!cols[j].equals("null")){
                    newnode = new TreeNode(Integer.valueOf(cols[j]));
                }
                if(j%2==0){
                    cur.left = newnode;
                }else {
                    cur.right = newnode;
                    if(j<cols.length-1){
                        cur = queue.poll();
                    }
                }
                queue.offer(newnode);
            }
        }
        return root;
    }


    public static void main(String[] args){
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        String str = codec.serialize(root);
        System.out.println(str);

        root = codec.deserialize(str);
        System.out.println(root);
    }
}
