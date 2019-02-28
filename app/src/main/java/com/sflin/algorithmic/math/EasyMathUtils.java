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
        if (n < 2) return 0;

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
}
