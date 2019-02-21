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

    /**
     * 买卖股票的最佳时机
     *
     * @param prices
     * @return
     *
     * 示例
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < prices.length;i++){
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > profit){
                profit = prices[i] - min;
            }
        }
        return profit;
    }
//    public int maxProfit(int[] prices) {
//        int profit = 0;
//        for (int i = 0;i < prices.length - 1;i++){
//            for (int j = i+1;j < prices.length;j++){
//                if (prices[i] < prices[j]){
//                    int value = prices[j] - prices[i];
//                    profit = value > profit?value:profit;
//                }
//            }
//        }
//        return profit;
//    }

    /**
     * 最大子序和
     *
     * @param nums
     * @return
     *
     * 示例
     * 输入: [-2,1,-3,4,-1,2,1,-5,4,8],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num:nums){
            sum += num;
            if (sum > max){
                max = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return max;
    }
//    public static int maxSubArray(int[] nums) {
//        int max = nums[0];
//
//        int[] com = new int[nums.length];
//        com[0] = nums[0];
//        for (int i = 1;i<nums.length;i++){
//            com[i] = com[i-1]+nums[i];
//        }
//        for (int i=0;i<nums.length;i++){
//            int sum = 0;
//            for (int j=i;j < nums.length;j++){
//                sum += nums[j];
//                if (sum > max){
//                    max = sum;
//                }
//            }
//        }
//        return max;
//    }
}
