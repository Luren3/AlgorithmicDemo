package com.sflin.algorithmic.tree;

import java.util.*;

/**
 * Created by MagicFrost
 * <p>
 * 初级树算法
 */
public class EasyTreeUtils {

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return 示例
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

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
     * 对称二叉树
     *
     * @param root
     * @return
     *
     * 示例
     * 二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     */
    //递归
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return comparison(root.left,root.right);
    }
    private static boolean comparison(TreeNode p,TreeNode q){

        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return comparison(p.left,q.right) && comparison(p.right,q.left);
    }
//    //迭代
//    public static boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root.left);
//        q.add(root.right);
//        while (!q.isEmpty()) {
//            TreeNode t1 = q.poll();
//            TreeNode t2 = q.poll();
//            if (t1 == null && t2 == null) continue;
//            if (t1 == null || t2 == null) return false;
//            if (t1.val != t2.val) return false;
//            q.add(t1.left);
//            q.add(t2.right);
//            q.add(t1.right);
//            q.add(t2.left);
//        }
//        return true;
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
     * 将有序数组转换为二叉搜索树
     *
     * @param nums
     * @return
     *
     * 示例
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length - 1);
    }
    private static TreeNode sortedArrayToBST(int[] nums,int left,int right){
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums,left,mid - 1);
        node.right = sortedArrayToBST(nums,mid+1,right);
        return node;
    }
}
