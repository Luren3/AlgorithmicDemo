package com.sflin.algorithmic.string;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created MagicFrost.
 * <p>
 * 简单字符串算法
 */
public class EasyStringUtils {


    /**
     * 反转字符串
     *
     * @param s
     * @return 示例
     * 输入: "hello"
     * 输出: "olleh"
     */
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return new String(chars);
    }

    /**
     * 541. 反转字符串 II
     *
     * @param s
     * @param k
     * @return 示例
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     */
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    /**
     * 整数反转
     *
     * @param x
     * @return 示例
     * 输入: 123
     * 输出: 321
     */
//    public int reverse(int x) {
//
//        try {
//            if (x >= 0){
//                x = Integer.parseInt(reverseString(""+x));
//            }else {
//                x = 0 - Integer.parseInt(reverseString(""+Math.abs(x)));
//            }
//        }catch (NumberFormatException e){
//            return 0;
//        }
//
//        return x;
//    }
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            result = result * 10 + pop;
            x /= 10;
        }
        return result;
    }

    /**
     * 387.字符串中的第一个唯一字符
     *
     * @param s
     * @return 示例
     * s = "leetcode"
     * 返回 0.
     * <p>
     * s = "loveleetcode",
     * 返回 2.
     */
    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            int index = s.indexOf(s.charAt(i));
            if (s.lastIndexOf(s.charAt(i)) == index) {
                return i;
            }
        }
        return -1;
    }
//    public int firstUniqChar(String s) {
//
//        Map<Character,Integer> map = new HashMap<>();
//        for (int i=0;i<s.length();i++){
//            if (map.containsKey(s.charAt(i))){
//                int num = map.get(s.charAt(i)) + 1;
//                map.put(s.charAt(i),num);
//            }else {
//                map.put(s.charAt(i),1);
//            }
//        }
//
//        for (int i=0;i<s.length();i++){
//            if (map.get(s.charAt(i)) == 1){
//
//                return i;
//            }
//        }
//        return -1;
//    }

    /**
     * 有效的字母异位词
     *
     * @param s
     * @param t
     * @return 示例
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * <p>
     * 提示:相同种类、数量字母的不同排列
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);

        if (!String.valueOf(chars1).equals(String.valueOf(chars2))) {
            return false;
        }
        return true;
    }

    /**
     * 验证回文字符串
     *
     * @param s
     * @return 示例
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     */
    public static boolean isPalindrome(String s) {
        //可以替换大部分空白字符， 不限于空格 . 说明:\s 可以匹配空格、制表符、换页符等空白字符的其中任意一个
        s = s.trim().replaceAll("\\s*", "");
        //清除所有符号,只留下字母 数字  汉字  共3类.
        s = s.replaceAll("[\\p{P}\\p{Punct}]", "").toLowerCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 680. 验证回文字符串 Ⅱ
     *
     * @param s
     * @return
     *
     * 示例
     *
     */
    public boolean validPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j ; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;
    }
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串转换整数 (atoi)
     *
     * @param str
     * @return 示例
     * 输入: "42"
     * 输出: 42
     */
    public static int myAtoi(String str) {
        str = str.trim();

        if (str.length() == 0) return 0;

        if (str.equals("+") || str.equals("-")) return 0;

        String string = "" + str.charAt(0);

        if ((!(string.equals("+") || string.equals("-") || isNumber(str.charAt(0))))) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(string);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isNumber(c)) {
                builder.append(c);
            } else {
                break;
            }
        }
        if (builder.toString().equals("+") || builder.toString().equals("-")) return 0;
        Double num = Double.parseDouble(builder.toString());
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return num.intValue();
    }

    private static boolean isNumber(char c) {
        String number = "0123456789";
        if (number.indexOf(c) == -1) {
            return false;
        }
        return true;
    }

    /**
     * 实现strStr()
     *
     * @param haystack
     * @param needle
     * @return 示例
     * 输入: haystack = "mississippi", needle = "issipi"
     * 输出: 4
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        final int sourceLength = haystack.length();
        final int targetLength = needle.length();

        char first = needle.charAt(0);
        int max = (sourceLength - targetLength);

        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first) ;
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + targetLength - 1;
                for (int k = 1; j < end && haystack.charAt(j)
                        == needle.charAt(k); j++, k++)
                    ;

                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }
//    public static int strStr(String haystack, String needle) {
//        if (needle.length() == 0) return 0;
//        if (needle.length() > haystack.length()) return -1;
//
//        for (int i = 0;i < haystack.length();i ++){
//            if (haystack.charAt(i) == needle.charAt(0)){
//                int j = i + 1;
//                int end = j + needle.length() - 1;
//                for (int k = 1;k < needle.length() && j < haystack.length();j++,k ++){
//                    if (haystack.charAt(j) != needle.charAt(k)){
//                        break;
//                    }
//                }
//
//                if (j == end) return i;
//            }
//        }
//        return -1;
//    }

    /**
     * 报数
     *
     * @param n
     * @return 示例
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 6.     312211
     */
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        String str = "11";
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i < n; i++) {
            char c = str.charAt(0);
            int index = 1;
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == c) {
                    index++;
                } else {
                    builder.append(index);
                    builder.append(c);
                    c = str.charAt(j);
                    index = 1;
                }
                if (j == str.length() - 1) {
                    builder.append(index);
                    builder.append(c);
                }
            }
            str = builder.toString();
            builder.setLength(0);
        }
        return str;
    }

    /**
     * 最长公共前缀
     *
     * @param strs
     * @return 示例
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String repeat = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //不是从第一位开始相等的,就将最后一位去掉
            while (strs[i].indexOf(repeat) != 0) {
                repeat = repeat.substring(0, repeat.length() - 1);
                if (repeat.length() == 0) return "";
            }
        }
        return repeat;
    }
//    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        List<String> list = new ArrayList<>();
//        for (int i = 0;i < strs.length;i ++){
//            list.add(strs[i]);
//        }
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        String shortStr = list.get(0);
//        list.remove(shortStr);
//
//        String str = "";
//        for (int i = 0;i < shortStr.length();i ++){
//            for (String string:list){
//                if (shortStr.charAt(i) != string.charAt(i)){
//                    return str;
//                }
//            }
//            str += shortStr.charAt(i);
//        }
//
//        return str;
//    }


    /**
     * 409. 最长回文串
     *
     * @param s
     * @return 示例
     * 输入:
     * "abccccdd"
     * <p>
     * 输出:
     * 7
     * <p>
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */
    public static int longestPalindrome(String s) {
        if (s == null) return 0;

        int[] f = new int[75];
        for (char ch : s.toCharArray()) {
            f[ch - '0']++;
        }
        int res = 0, odd = 0;
        for (int num : f) {
            if (num == 0) continue;
            res += num / 2 * 2;

            if (num % 2 == 1) {
                odd = 1;
            }
        }
        res += odd;
        return res;
    }
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public static int longestPalindrome(String s) {
//        //字符个数偶数可以组成，如果有奇数取最长个数字符，其他剔除一个
//        Map<Character,Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        int result = 0,odd = 0;
//        for (Integer integer:map.values()) {
//            result += integer / 2 * 2;
//            if (integer % 2 == 1){
//                odd = 1;
//            }
//        }
//        return result + odd;
//    }

    /**
     * 151. 翻转字符串里的单词
     *
     * @param s
     * @return 示例
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     */
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");

        StringBuilder builder = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]).append(" ");
        }
        return builder.toString().trim();
    }

    /**
     * 557. 反转字符串中的单词 III
     *
     * @param s
     * @return 示例
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     */
    public String reverseWords2(String s) {
        String[] arr = s.trim().split("\\s+");

        StringBuilder builder = new StringBuilder();
        for (String str : arr) {
            builder.append(reverseString(str)).append(" ");
        }
        return builder.toString().trim();
    }

    /**
     * 917. 仅仅反转字母
     *
     * @param S
     * @return 示例
     * 输入："ab-cd"
     * 输出："dc-ba"
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c : S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }


    /**
     * 205. 同构字符串
     *
     * @param s
     * @param t
     * @return 示例
     * 输入: s = "egg", t = "add"
     * 输出: true
     */
    public boolean isIsomorphic(String s, String t) {
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            char c1 = s1[i];
            char c2 = t1[i];
            if (arr1[c1] != arr2[c2]) {
                return false;
            }
            arr1[c1] = i + 1;
            arr2[c2] = i + 1;
        }
        return true;
    }
}
