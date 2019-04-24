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
     * s = "aaabb", k = 3
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
}
