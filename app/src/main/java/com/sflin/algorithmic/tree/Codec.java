package com.sflin.algorithmic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by MagicFrost.
 *
 * 二叉树的序列化与反序列化
 *
 * 示例
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                sb.append("null,");
            }else {
                sb.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        LockSupport.park();
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] dataArr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[index]));
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            String value = dataArr[++index];
            if (!value.equals("null")){
                node.left = new TreeNode(Integer.parseInt(value));
                queue.add(node.left);
            }
            value = dataArr[++index];
            if (!value.equals("null")){
                node.right = new TreeNode(Integer.parseInt(value));
                queue.add(node.right);
            }
        }
        return root;
    }
}
