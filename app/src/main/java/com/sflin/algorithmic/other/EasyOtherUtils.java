package com.sflin.algorithmic.other;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 颠倒二进制位
     *
     * @param n
     * @return
     *
     * 示例
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
     */
//    public static int reverseBits(int n) {
//        int result = 0;
//        for (int i = 0; i < Integer.SIZE; i++) {
//            result <<= 1;
//            result |= n & 1;
//            n >>>= 1;
//        }
//        return result;
//    }
    public static int reverseBits(int n) {
        n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;
        n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;
        n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;
        n = (n & 0x00ff00ff) << 8 | (n >>> 8) & 0x00ff00ff;
        n = (n & 0x0000ffff) << 16 | (n >>> 16) & 0x0000ffff;
        return n;
    }

    /**
     * 杨辉三角
     *
     * @param numRows
     * @return
     *
     * 示例
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            int num = 1;
            List<Integer> list = new ArrayList<>();
            for (int j=0;j<=i;j++){
                list.add(num);
                num = num * (i - j)/(j + 1);
            }
            lists.add(list);
        }
        return lists;
    }
}
