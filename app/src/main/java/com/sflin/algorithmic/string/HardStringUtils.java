package com.sflin.algorithmic.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created MagicFrost.
 *
 * 困难字符串算法
 */
public class HardStringUtils {

    /**
     * 单词拆分 II
     *
     * @param s
     * @param wordDict
     * @return
     *
     * 示例
     *
     * 输入:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * 输出:
     * [
     *   "cats and dog",
     *   "cat sand dog"
     * ]
     */
    public static List<String> wordBreak(String s, List<String> wordDict) {
        if (!dp(s,wordDict)){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        dfs(s,list,wordDict,new StringBuilder(),0);
        return list;
    }

    private static boolean dp(String s,List<String> wordDict) {
        int n = s.length();
        int max_length=0;
        for(String temp:wordDict){
            max_length = temp.length()>max_length? temp.length():max_length;
        }
        boolean[] memo = new boolean[n + 1];

        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >=0 && max_length>=i-j; j--) {
                String str = s.substring(j, i);
                if (memo[j] && wordDict.contains(str)) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    private static void dfs(String s,List<String> list,List<String> wordDict,StringBuilder sb,int index){
        if (index == s.length()){
            list.add(sb.toString().trim());
            return;
        }
        for (int i=index;i<s.length();i++){
            String str = s.substring(index,i+1);
            if (wordDict.contains(str)){
                int len = sb.length();
                sb.append(str).append(" ");
                dfs(s,list,wordDict,sb,i+1);
                sb.setLength(len);
            }
        }
    }

    /**
     * 单词搜索 II
     *
     * @param board
     * @param words
     * @return
     * 示例
     * 输入:
     * words = ["oath","pea","eat","rain"] and board =
     * [
     *   ['o','a','a','n'],
     *   ['e','t','a','e'],
     *   ['i','h','k','r'],
     *   ['i','f','l','v']
     * ]
     *
     * 输出: ["eat","oath"]
     */
    public List<String> findWords(char[][] board, String[] words) {
        return null;
    }
}
