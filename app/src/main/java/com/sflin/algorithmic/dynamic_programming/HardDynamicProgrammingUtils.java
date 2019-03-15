package com.sflin.algorithmic.dynamic_programming;

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
}
