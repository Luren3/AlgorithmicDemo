package com.sflin.algorithmic.dynamic_programming;

/**
 * Created by MagicFrost
 *
 * 初级动态规划算法
 */
public class EasyDynamicProgrammingUtils {

    /**
     * 爬楼梯
     *
     * @param n
     * @return
     *
     * 示例
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     */
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int p = 2,q = 1;
        for (int i = 2;i<n;i++){
            int sum = p + q;
            q = p;
            p = sum;
        }
        return p;
    }
//    public static int climbStairs(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        return climbStairs(n-1)+climbStairs(n-2);
//    }
}
