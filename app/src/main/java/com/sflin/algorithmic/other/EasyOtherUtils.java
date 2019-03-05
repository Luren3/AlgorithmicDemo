package com.sflin.algorithmic.other;

/**
 * Created by MagicFrost
 *
 * 初级其他算法
 */
public class EasyOtherUtils {

    /**
     * 位1的个数
     *
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     * @param n
     * @return
     *
     * 示例
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * 注意：需要将n视为无符号值
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
