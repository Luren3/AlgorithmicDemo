package com.sflin.algorithmic.dynamic_programming;

import com.sflin.algorithmic.tree.TreeNode;

/**
 * Created by MagicFrost
 *
 * 困难动态规划算法
 */
public class HardDynamicProgrammingUtils {

    /**
     * 鸡蛋掉落
     *
     * @param K
     * @param N
     * @return
     *
     * 示例
     * 输入：K = 2, N = 6
     * 输出：3
     */
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }

    /**
     * 二叉树中的最大路径和
     *
     * @param root
     * @return
     *
     * 输入: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * 输出: 6
     */
    private static int ret = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        /**
         对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
         2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
         **/
        ret = Integer.MIN_VALUE;
        getMax(root);
        return ret;
    }
    private static int getMax(TreeNode r) {
        if(r == null) return 0;
        int left = Math.max(0, getMax(r.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(r.right));
        ret = Math.max(ret, r.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + r.val;
    }
}
