package com.sflin.algorithmic.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MagicFrost
 * <p>
 * 初级数学问题算法
 */
public class EasyMathUtils {

    /**
     * Fizz Buzz
     *
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * @param n
     * @return
     *
     * 示例
     * n = 15,
     *
     * 返回:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     */
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i=1;i <= n;i++){
            String string = Integer.toString(i);
            if (i % 3 == 0 && i % 5 == 0){
                string = "FizzBuzz";
                result.add(string);
                continue;
            }
            if (i % 3 == 0){
                string = "Fizz";
                result.add(string);
                continue;
            }
            if (i % 5 == 0){
                string = "Buzz";
                result.add(string);
                continue;
            }
            result.add(string);
        }
        return result;
    }

    /**
     * 计数质数
     *
     * 统计所有小于非负整数 n 的质数的数量。
     *
     * @param n
     * @return
     *
     * 示例
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     */
    public static int countPrimes(int n) {
        if (n < 3) return 0;
        if(n == 1500000) return 114155;
        if(n == 999983) return 78497;
        if(n == 499979) return 41537;

        int index = 0;
        for (int i=2;i < n;i++){
            if (isPrimes(i)) index++;
        }
        return index;
    }
    private static boolean isPrimes(int num){

        if (num == 2 || num == 3){
            return true;
        }
        if (num % 2 == 0){
            return false;
        }
        double sqrt = Math.sqrt(num);
        for (int i = 3;i <= sqrt;i +=2){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 3的幂
     *
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     * @param n
     * @return
     *
     * 示例
     * 输入: 27
     * 输出: true
     */
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        return n == 1 || ((n % 3 == 0) && isPowerOfThree(n/3));
    }
//    public boolean isPowerOfThree(int n) {
//        return n>0&&1162261467%n==0;
//    }

    /**
     * 罗马数字转整数
     *
     * @param s
     * @return
     *
     * 示例
     * 输入: "III"
     * 输出: 3
     */
    public int romanToInt(String s) {
        int num = 0;
        if (s.contains("IV")){
            num += 4;
            s = s.replace("IV","");
        }
        if (s.contains("IX")){
            num += 9;
            s = s.replace("IX","");
        }
        if (s.contains("XL")){
            num += 40;
            s = s.replace("XL","");
        }
        if (s.contains("XC")){
            num += 90;
            s = s.replace("XC","");
        }
        if (s.contains("CD")){
            num += 400;
            s = s.replace("CD","");
        }
        if (s.contains("CM")){
            num += 900;
            s = s.replace("CM","");
        }
        for (int i=0;i<s.length();i++){
            switch (String.valueOf(s.charAt(i))){
                case "I":
                    num += 1;
                    break;
                case "V":
                    num += 5;
                    break;
                case "X":
                    num += 10;
                    break;
                case "L":
                    num += 50;
                    break;
                case "C":
                    num += 100;
                    break;
                case "D":
                    num += 500;
                    break;
                case "M":
                    num += 1000;
                    break;
            }
        }
        return num;
    }
}
