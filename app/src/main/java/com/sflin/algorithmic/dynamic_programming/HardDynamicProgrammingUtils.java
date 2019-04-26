package com.sflin.algorithmic.dynamic_programming;

import java.util.Arrays;

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
     * 最长连续序列
     *
     * @param nums
     * @return
     * 示例
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int length = 0,tmp = 0;
        for (int i=1;i<nums.length;i++){
            int diff = nums[i]-nums[i-1];
            if(diff == 1){
                tmp++;
            }else if (diff>1){
                length = Math.max(length,tmp+1);
                tmp = 0;
            }
        }
        length = Math.max(length,tmp+1);
        return length;
    }
}
