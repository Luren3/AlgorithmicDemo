package com.sflin.algorithmic.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by MagicFrost
 * <p>
 * 中等树算法
 */
public class MediumTreeUtils {

    /**
     * 验证二叉搜索树
     *
     * @param root
     * @return 说明
     * 假设一个二叉搜索树具有如下特征：
     * 1.节点的左子树只包含小于当前节点的数。
     * 2.节点的右子树只包含大于当前节点的数。
     * 3.所有左子树和右子树自身必须也是二叉搜索树。
     * <p>
     * 示例
     * 输入:
     * 2
     * / \
     * 1  3
     * 输出: true
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max) return false;
        if (root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
//    //中序遍历
//    public static boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        List<Integer> list = new ArrayList<>();
//        addToList(root, list);
//        for (int i = 1;i < list.size();i ++){
//            if (list.get(i - 1) >= list.get(i)){
//                return false;
//            }
//        }
//        return true;
//    }
//    private static void addToList(TreeNode root, List<Integer> list) {
//        if (root == null) return;
//        addToList(root.left, list);
//        list.add(root.val);
//        addToList(root.right, list);
//    }

    /**
     * 二叉树的层次遍历
     *
     * @param root
     * @return 示例
     * 给定二叉树: [3,9,20,null,null,15,7]
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (list.size() != 0) {
                lists.add(list);
            }
        }

        return lists;
    }

    /**
     * 二叉搜索树中第K小的元素
     *
     * @param root
     * @param k
     * @return 示例
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     * 2
     * 输出: 1
     */
    public static int index = 0, value = 0;

    public static int kthSmallest(TreeNode root, int k) {
        index = 0;
        value = 0;
        preOrderTravers(root, k);
        return value;
    }

    private static void preOrderTravers(TreeNode root, int k) {
        if (root == null) return;
        preOrderTravers(root.left, k);
        index++;
        if (index == k) {
            value = root.val;
        }
        preOrderTravers(root.right, k);
    }

    /**
     * 236.二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return 示例
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * <p>
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


    /**
     * 144. 二叉树的前序遍历
     *
     * @param root
     * @return 给定一个二叉树，返回它的 前序 遍历。
     * <p>
     * 示例
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,2,3]
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helperPreOrder(root, list);
        return list;
    }

    private void helperPreOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helperPreOrder(root.left, list);
        helperPreOrder(root.right, list);
    }

    /**
     * 429. N叉树的层序遍历
     *
     * @param root
     * @return 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null){
            helperLevelOrder(root, lists,0);
        }
        return lists;
    }

    private void helperLevelOrder(Node root, List<List<Integer>> lists,int level) {
        if (lists.size() == level){
            lists.add(new ArrayList<Integer>());
        }
        lists.get(level).add(root.val);
        for (Node node : root.children) {
            helperLevelOrder(node,lists,level + 1);
        }
    }

//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null) return result;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            List<Integer> level = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                level.add(node.val);
//                queue.addAll(node.children);
//            }
//            result.add(level);
//        }
//        return result;
//    }

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     *
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 示例
     *
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return  helperBuildTree(0,inorder.length,map,preorder);
    }

    private int rootIndex = 0;
    private TreeNode helperBuildTree(int left, int right, Map<Integer, Integer> map, int[] preorder) {
        if (left >= right || rootIndex == preorder.length) {
            return null;
        }
        int value = preorder[rootIndex];
        TreeNode root = new TreeNode(value);

        rootIndex++;
        int index = map.get(value);
        root.left = helperBuildTree(left,index,map,preorder);
        root.right = helperBuildTree(index + 1,right,map,preorder);
        return root;
    }
}
