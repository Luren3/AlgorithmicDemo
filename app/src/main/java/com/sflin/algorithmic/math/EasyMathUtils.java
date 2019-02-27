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
    public List<String> fizzBuzz(int n) {
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
}
