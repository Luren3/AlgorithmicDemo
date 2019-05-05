package com.sflin.algorithmic.dynamic_programming;

/**
 * Created by MagicFrost
 * <p>
 * 中等动态规划算法
 */
public class MediumDynamicProgrammingUtils {

    /**
     * 至少有K个重复字符的最长子串
     *
     * @param s
     * @param k
     * @return 示例
     * 输入:
     * s = "bbaaacbd", k = 3
     * <p>
     * 输出:
     * 3
     * <p>
     * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     */
    public static int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        } else if (k == 1) {
            return s.length();
        }
        return longestSubstring(s, 0, s.length() - 1, k);
    }
    private static int longestSubstring(String s, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }
        int[] counts = new int[26];

        for (int i = left; i <= right; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        int last = left, maxLength = 0;
        boolean isSplit = false;

        for (int i = left; i <= right; i++) {
            if (isSplit(counts, s.charAt(i), k)) {
                maxLength = Math.max(maxLength, longestSubstring(s, last, i - 1, k));
                last = i + 1;
                isSplit = true;
            } else if (i == right && isSplit) {
                maxLength = Math.max(maxLength, longestSubstring(s, last, right, k));
            }
        }
        if (isSplit) {
            return maxLength;
        } else {
            return right - left + 1;
        }
    }
    private static boolean isSplit(int[] counts, char c, int k) {
        int i = c - 'a';
        return counts[i] > 0 && counts[i] < k;
    }

    /**
     * 完全平方数
     * @param n
     * @return
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     *
     * n = 4^a(8b+7)
     */
//    public int numSquares(int n) {
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i=1;i<=n;i++){
//            int min = Integer.MAX_VALUE;
//            int j = 1;
//            while(i - j*j >= 0) {
//                min = Math.min(min, dp[i - j*j] + 1);
//                j++;
//            }
//            dp[i] = min;
//        }
//        return dp[n];
//    }
    public int numSquares(int n) {
        //先根据上面提到的公式来缩小n
        while (n % 4 == 0){
            n /= 4;
        }
        if (n % 8 == 7){//满足四平方和定
            return 4;
        }
        //在判断缩小后的数是否可以由一个数的平方或者两个数平方的和组成
        int a = 0;
        while(a * a < n) {
            int b = (int) Math.sqrt(n - a * a);
            if(a * a + b * b == n) {
                if(a == 0 && b == 0) return 0;
                else if(a != 0 && b != 0) return 2;
                else return 1;
            }
            a = a + 1;
        }
        //如果不是返回3
        return 3;
    }

    /**
     * 最长上升子序列
     *
     * @param nums
     * @return
     * 示例
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
//    public static int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        int max = 0;
//        for (int i=0;i<nums.length;i++){
//            dp[i] = 1;
//            for (int j=0;j<i;j++){
//                if (nums[j]<nums[i]){
//                    dp[i] = Math.max(dp[i],dp[j]+1);
//                }
//            }
//            max = Math.max(max,dp[i]);
//        }
//        return max;
//    }[5,9,6,5,7,4,8,2]
    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int result=0;
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp[result]){
                dp[++result]=nums[i];
            }else{
                int left=0;
                int right=result;
                while(left<right){
                    int mid=(left+right)/2;
                    if(nums[i]<=dp[mid]){
                        right=mid;
                    }else{
                        left=mid+1;
                    }
                }
                dp[right]=nums[i];
            }
        }
        return result+1;
    }

    /**
     * 零钱兑换
     *
     * @param coins
     * @param amount
     * @return
     *
     * 示例
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++){
                int value = i-coins[j];
                if (value>=0 && dp[value] != -1){
                  min = Math.min(min,dp[value]+1);
                }
            }
            min = min==Integer.MAX_VALUE ? -1 : min;
            dp[i] = min;
        }
        return dp[amount];
    }
}
