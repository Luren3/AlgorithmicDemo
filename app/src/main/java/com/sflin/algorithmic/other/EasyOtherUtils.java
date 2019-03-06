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

    /**
     * 汉明距离
     *
     * @param x
     * @param y
     * @return
     *
     * 示例
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     *
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * 上面的箭头指出了对应二进制位不同的位置。
     */
    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
