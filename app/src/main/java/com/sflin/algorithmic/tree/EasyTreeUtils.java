package com.sflin.algorithmic.tree;

/**
 * Created by MagicFrost
 *
 * 初级树算法
 */
public class EasyTreeUtils {

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     *
     * 示例
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
