package com.sflin.algorithmic.dynamic_programming;

import java.util.Arrays;

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
     *
     * @param n
     * @return 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * <p>
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
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {//满足四平方和定
            return 4;
        }
        //在判断缩小后的数是否可以由一个数的平方或者两个数平方的和组成
        int a = 0;
        while (a * a < n) {
            int b = (int) Math.sqrt(n - a * a);
            if (a * a + b * b == n) {
                if (a == 0 && b == 0) return 0;
                else if (a != 0 && b != 0) return 2;
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
     * @return 示例
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i=0;i<nums.length;i++){
            dp[i] = 1;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
//    public static int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int result = 0;
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > dp[result]) {
//                dp[++result] = nums[i];
//            } else {
//                int left = 0;
//                int right = result;
//                while (left < right) {
//                    int mid = (left + right) / 2;
//                    if (nums[i] <= dp[mid]) {
//                        right = mid;
//                    } else {
//                        left = mid + 1;
//                    }
//                }
//                dp[right] = nums[i];
//            }
//        }
//        return result + 1;
//    }

    /**
     * 零钱兑换
     *
     * @param coins
     * @param amount
     * @return 示例
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = coins.length - 1; j >= 0; j--) {
                int value = i - coins[j];
                if (value >= 0 && dp[value] != -1) {
                    min = Math.min(min, dp[value] + 1);
                }
            }
            min = min == Integer.MAX_VALUE ? -1 : min;
            dp[i] = min;
        }
        return dp[amount];
    }

    /**
     * 64. 最小路径和
     *
     * @param grid
     * @return 示例
     * 输入:
     * [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    public int minPathSum(int[][] grid) {

        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 91. 解码方法
     *
     * @param s
     * @return 示例
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     */
    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            char pre = s.charAt(i - 1);
            dp[i + 1] = c == '0' ? 0 : dp[i];
            if (pre == '1' || (pre == '2' && c <= '6')) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];
    }
//    public int numDecodings(String s) {
//        char[] arr = s.toCharArray();
//        int[] dp = new int[s.length() + 1];
//        dp[0] = 1;
//        dp[1] = arr[0] == '0' ? 0 : 1;
//        if (s.length() <= 1) return dp[1];
//        for (int i = 2; i <= s.length(); i++) {
//            int n = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
//            if (arr[i - 1] == '0' && arr[i - 2] == '0') {
//                return 0;
//            } else if (arr[i - 2] == '0') {
//                dp[i] = dp[i - 1];
//            } else if (arr[i - 1] == '0') {
//                if (n > 26) return 0;
//                dp[i] = dp[i - 2];
//            } else if (n > 26) {
//                dp[i] = dp[i - 1];
//            } else {
//                dp[i] = dp[i - 1] + dp[i - 2];
//            }
//        }
//        return dp[dp.length - 1];
//    }

    /**
     * 221. 最大正方形
     *
     * @param matrix
     * @return 示例
     * 输入:
     * <p>
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * <p>
     * 输出: 4
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }


    /**
     * 621. 任务调度器
     *
     * @param tasks
     * @param n
     * @return 示例
     * <p>
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
     * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     * <p>
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     * 如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     * 则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        //步骤1
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        //步骤2
        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        //步骤3
        while (i >= 0 && counts[i] == maxCount) {
            retCount++;
            i--;
        }
        //步骤4
        return Math.max(retCount, tasks.length);
    }

    /**
     * 5. 最长回文子串
     *
     * @param s
     * @return
     *
     * 示例
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     */
    public String longestPalindrome(String s) {
        String res = "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i) && ((i - j < 2) || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (res.length() <= (i - j)) {
                        res = s.substring(j, i + 1);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 647. 回文子串
     *
     * @param s
     * @return 示例
     * 输入: "abc"
     * 输出: 3
     * 解释: 三个回文子串: "a", "b", "c".
     */
    public int countSubstrings(String s) {
        int res = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i) && ((i - j < 2) || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
