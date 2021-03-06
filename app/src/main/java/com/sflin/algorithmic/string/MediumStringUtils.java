package com.sflin.algorithmic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
     * @return 示例
     * s = "abc", t = "ahbgdc"
     * <p>
     * 返回 true.
     */
    public static boolean isSubsequence(String s, String t) {

        if (s.length() == 0) return true;
        int index = 0;

        for (int i = 0; i < t.length(); i++) {
            if (index >= s.length()) {
                return true;
            }
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
        }
        if (index != s.length()) return false;
        return true;
    }

    /**
     * 49. 字母异位词分组
     *
     * @param strs
     * @return 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        //思路：对数组中每个字符串重新排序，相等的就是字母异位词
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String newStr = String.valueOf(chars);
//            if (map.containsKey(newStr)) {
//                map.get(newStr).add(str);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(newStr, list);
//            }
//        }
//
//        return new ArrayList<>(map.values());
//    }

    /**
     * 127. 单词接龙
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return 示例
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * 输出: 5
     * <p>
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * 返回它的长度 5。
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> start = new HashSet<>();
        start.add(beginWord);
        HashSet<String> end = new HashSet<>();
        end.add(endWord);
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        return deBfs(start, end, words, 2);
    }

    private int deBfs(HashSet<String> start, HashSet<String> end, HashSet<String> words, int depth) {

        if (start.size() > end.size()) {
            return deBfs(end, start, words, depth);
        }
        words.removeAll(start);
        HashSet<String> next = new HashSet<>();
        for (String str : start) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String word = new String(chars);
                    if (words.contains(word)) {
                        if (end.contains(word)) {
                            return depth;
                        }
                        next.add(word);
                    }
                }
                chars[i] = temp;
            }
        }
        if (start.isEmpty()) {
            return 0;
        }
        return deBfs(next, end, words, depth + 1);

    }
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (wordList == null || !wordList.contains(endWord)) return 0;
//        boolean[] visited = new boolean[wordList.size()];
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//        //深度
//        int res = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            res++;
//            for (int i = 0; i < size; i++) {
//                String poll = queue.poll();
//                for (int j = 0; j < wordList.size(); j++) {
//                    //已经访问过的元素跳过,树中不存在重复节点
//                    if (visited[j]) {
//                        continue;
//                    }
//                    //孩子节点只能改变一个字符转换为s,不满足则跳过
//                    if (!progress(poll, wordList.get(j))) {
//                        continue;
//                    }
//                    //如果节点s等于endWord,接龙完成
//                    if (wordList.get(j).equals(endWord)) {
//                        return res + 1;
//                    }
//                    visited[j] = true;
//                    queue.add(wordList.get(j));
//                }
//            }
//        }
//        return 0;
//    }
//    private boolean progress(String poll, String s) {
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (poll.charAt(i) != s.charAt(i)) {
//                count++;
//                if (count > 1) {
//                    return false;
//                }
//            }
//        }
//        return count == 1;
//    }

}
