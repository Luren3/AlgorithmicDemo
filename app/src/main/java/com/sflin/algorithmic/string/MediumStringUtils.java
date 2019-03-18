package com.sflin.algorithmic.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created MagicFrost.
 *
 * 中等字符串算法
 */
public class MediumStringUtils {

    /**
     * 分割回文串
     *
     * @param s
     * @return
     *
     * 示例
     *
     * 输入: "aab"
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        partition(lists,s,0,new ArrayList<String>());
        return lists;
    }

    private static void partition(List<List<String>> lists,String s,int index,List<String> list) {
        if (index == s.length()){
            lists.add(new ArrayList<String>(list));
        }
        for (int i=index;i<s.length();i++){
            String str = s.substring(index,i+1);
            if (isPalindrome(str)){
                list.add(str);
                partition(lists,s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean isPalindrome(String s) {
        for (int i = 0;i < s.length()/2;i ++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
