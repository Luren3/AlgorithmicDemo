package com.sflin.algorithmic.tree;

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
     * 2
     * / \
     * 1   3
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
}
