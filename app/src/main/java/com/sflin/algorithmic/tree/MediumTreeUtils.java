package com.sflin.algorithmic.tree;

import java.util.*;

/**
 * Created by MagicFrost
 *
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
     *   2
     *  / \
     * 1  3
     * 输出: true
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private static boolean isValidBST(TreeNode root,long min,long max){
        if (root == null) return true;
        if (root.val >= max) return false;
        if (root.val <= min) return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
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
     * @return
     *
     * 示例
     * 给定二叉树: [3,9,20,null,null,15,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0;i < size;i ++){
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (list.size() != 0){
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
     * @return
     *
     * 示例
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 1
     */
    public static int index = 0,value = 0;
    public static int kthSmallest(TreeNode root, int k) {
        index = 0;
        value = 0;
        preOrderTravers(root,k);
        return value;
    }
    private static void preOrderTravers(TreeNode root,int k) {
        if (root == null) return;
        preOrderTravers(root.left, k);
        index++;
        if (index == k){
            value = root.val;
        }
        preOrderTravers(root.right,k);
    }

    /**
     * 二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     *
     * 示例
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     *
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
