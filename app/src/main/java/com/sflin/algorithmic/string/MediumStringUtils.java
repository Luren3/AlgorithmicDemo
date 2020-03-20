package com.sflin.algorithmic.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created MagicFrost.
 * <p>
 * 中等字符串算法
 */
public class MediumStringUtils {

    /**
     * 分割回文串
     *
     * @param s
     * @return 示例
     * <p>
     * 输入: "aab"
     * 输出:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        partition(lists, s, 0, new ArrayList<String>());
        return lists;
    }

    private static void partition(List<List<String>> lists, String s, int index, List<String> list) {
        if (index == s.length()) {
            lists.add(new ArrayList<String>(list));
        }
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (isPalindrome(str)) {
                list.add(str);
                partition(lists, s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 单词拆分
     *
     * @param s
     * @param wordDict
     * @return 示例
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++)
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j, i);
                if (dp[j] && wordDict.contains(tmp)) {
                    dp[i] = true;
                    break;
                }
            }
        return dp[len];
    }
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        int n = s.length();
//        int max_length=0;
//        for(String temp:wordDict){
//            max_length = temp.length()>max_length? temp.length():max_length;
//        }
//        boolean[] memo = new boolean[n + 1];
//
//        memo[0] = true;
//        for (int i = 1; i <= n; i++) {
//            for (int j = i-1; j >=0 && max_length>=i-j; j--) {
//                String str = s.substring(j, i);
//                if (memo[j] && wordDict.contains(str)) {
//                    memo[i] = true;
//                    break;
//                }
//            }
//        }
//        return memo[n];
//    }


    /**
     * 单词搜索
     *
     * @param board
     * @param word
     * @return 示例
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * 给定 word = "ABCCED", 返回 true.
     * 给定 word = "SEE", 返回 true.
     * 给定 word = "ABCB", 返回 false.
     */
    public boolean exist(char[][] board, String word) {

        if (word.length() == 0 || board.length == 0) {
            return false;
        }

        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(board, word, 0, i, j, flag)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int index, int i, int j, boolean[][] flag) {
        if (index == word.length()) {
            return true;
        }
        boolean result = false;
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && !flag[i][j] && word.charAt(index) == board[i][j]) {
            flag[i][j] = true;
            index += 1;
            result = find(board, word, index, i + 1, j, flag) || find(board, word, index, i - 1, j, flag) ||
                    find(board, word, index, i, j + 1, flag) || find(board, word, index, i, j - 1, flag);
            if (result == false) {
                index -= 1;
                flag[i][j] = false;
            }
        }
        return result;
    }

    /**
     * 简化路径
     *
     * @param path
     * @return 输入："/a//b////c/d//././/.."
     * 输出："/a/b/c"
     */
    public static String simplifyPath(String path) {

        String[] strings = path.split("/");

        List<String> list = new ArrayList<>();

        for (String str : strings) {
            switch (str) {
                case ".":
                case "":
                    break;
                case "..":
                    if (list.size() != 0) {
                        list.remove(list.size() - 1);
                    }
                    break;
                default:
                    list.add(str);
                    break;
            }
        }

        StringBuffer sb = new StringBuffer();

        for (String str : list) {
            sb.append("/");
            sb.append(str);
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    /**
     * 分割连接字符串
     *
     * @param strs
     * @return 示例
     * 输入: "abc", "xyz"
     * 输出: "zyxcba"
     */
    public static String splitLoopedString(String[] strs) {
        if (strs.length == 0)
            return "";

        String s = "";
        String[] revs = new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            StringBuilder tmp = new StringBuilder(strs[i]);
            revs[i] = tmp.reverse().toString();
            if (strs[i].compareTo(revs[i]) > 0)
                s += strs[i];
            else
                s += revs[i];
        }

        int k = 0;
        String res = "a";
        for (int i = 0; i < strs.length; i++) {
            String mid = s.substring(k + strs[i].length()) + s.substring(0, k);
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) >= res.charAt(0)) {
                    String str = strs[i].substring(j) + mid + strs[i].substring(0, j);
                    if (str.compareTo(res) > 0)
                        res = str;
                }
                // System.out.println(revs[i]+" "+res);
                if (revs[i].charAt(j) >= res.charAt(0)) {
                    String str = revs[i].substring(j) + mid + revs[i].substring(0, j);
                    if (str.compareTo(res) > 0)
                        res = str;
                }
            }
            k += strs[i].length();
        }

        return res;
    }

    /**
     * 无重复字符的最长子串
     *
     * @param s
     * @return 示例
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    break;
                } else {
                    map.put(s.charAt(j), s.charAt(j));
                }
            }
            length = Math.max(length, map.size());
            map.clear();
        }
        return length;
    }

    /**
     * @param s
     * @return 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。zzzz
     */
    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        String palindrome = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isPalindrome(str)) {
                    palindrome = palindrome.length() > str.length() ? palindrome : str;
                }
            }
        }

        return palindrome;
    }

    /**
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {

        return "";
    }

    /**
     * 判断子序列
     *
     * @param s
     * @param t
     * @return
     *
     * 示例
     * s = "abc", t = "ahbgdc"
     *
     * 返回 true.
     */
    public static boolean isSubsequence(String s, String t) {

        if (s.length() == 0) return true;
        int index = 0;

        for (int i = 0; i < t.length(); i++) {
            if (index >= s.length()){
                return true;
            }
            if (s.charAt(index) == t.charAt(i)){
                index++;
            }
        }
        if (index != s.length()) return false;
        return true;
    }
}
