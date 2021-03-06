package com.sflin.algorithmic.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by MagicFrost
 * <p>
 * 初级其他算法
 */
public class EasyOtherUtils {

    /**
     * 位1的个数
     * <p>
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     *
     * @param n
     * @return 示例
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * <p>
     * 注意：需要将n视为无符号值
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 汉明距离
     *
     * @param x
     * @param y
     * @return 示例
     * 输入: x = 1, y = 4
     * <p>
     * 输出: 2
     * <p>
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     * <p>
     * 上面的箭头指出了对应二进制位不同的位置。
     */
    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 颠倒二进制位
     *
     * @param n
     * @return 示例
     * 输入: 00000010100101000001111010011100
     * 输出: 00111001011110000010100101000000
     * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
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
     * @return 示例
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int num = 1;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(num);
                num = num * (i - j) / (j + 1);
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 有效的括号
     *
     * @param s
     * @return 示例
     * 输入: "()"
     * "{}[{}]((){})(){}"
     * 输出: true
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    if (c != ')') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                    continue;
                }
                if (stack.peek() == '[') {
                    if (c != ']') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                    continue;
                }
                if (stack.peek() == '{') {
                    if (c != '}') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                    continue;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 缺失数字
     *
     * @param nums
     * @return 示例
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     */
//    public int missingNumber(int[] nums) {
//        int res=nums.length;
//        for(int i=0;i<nums.length;i++){
//            res +=(i-nums[i]);
//        }
//        return res;
//    }
    public int missingNumber(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = n ^ i ^ nums[i];
        }
        return n ^ nums.length;
    }

    /**
     * 836. 矩形重叠
     *
     * @param rec1
     * @param rec2
     * @return 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
     * 输出：true
     */
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||    // bottom
                rec1[0] >= rec2[2] ||    // right
                rec1[1] >= rec2[3]);     // top
    }

    /**
     * 892. 三维形体的表面积
     *
     * @param grid
     * @return 示例
     * 输入：[[2]]
     * 输出：10
     */
    public static int surfaceArea(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        //统计所有的立方体数量
        int blocks = 0;
        //统计有多少个面被其他面盖住，那么就在所有的立方体的表面积上减去被盖住的面数×2（因为盖住一个面需要另一个面来盖，所以会损失2个面）；
        int cover = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                blocks += grid[i][j];
                //这个是统计当前格子中因为堆叠而盖住了几个面
                cover += grid[i][j] > 1 ? grid[i][j] - 1 : 0;
                if (i > 0) {
                    //看看上一行同一列盖住了多少个面
                    cover += Math.min(grid[i - 1][j], grid[i][j]);
                }
                if (j > 0) {
                    //看看同一行前一列盖住了几个面
                    cover += Math.min(grid[i][j - 1], grid[i][j]);
                }
            }
        }
        return blocks * 6 - cover * 2;
    }

    /**
     * 999. 车的可用捕获量
     *
     * @param board
     * @return 示例
     * 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],
     * [".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],
     * [".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
     * 输出：3
     * 解释：
     * 在本例中，车能够捕获所有的卒。
     */
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //先找到车的位置
                if (board[i][j] == 'R') {
                    //找到车在上下左右线上可捕获的卒
                    int result = findWithDirection(i, j, board);
                    return result;
                }
            }
        }
        return 0;
    }

    /**
     * @param x
     * @param y
     * @param board
     * @return
     */
    private int findWithDirection(int x, int y, char[][] board) {
        int res = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            while (true) {
                x += dx[k];
                y += dy[k];
                if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') {
                    break;
                }
                if (board[x][y] == 'p') {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 914. 卡牌分组
     *
     * @param deck
     * @return 示例
     * 输入：[1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] res = new int[1000];
        for (int i = 0; i < deck.length; i++) {
            res[deck[i]]++;
        }
        int g = -1;
        for (int j = 0; j < 1000; j++) {
            if (res[j] > 0) {
                if (g == -1) {
                    g = res[j];
                } else {
                    g = gcd(g, res[j]);
                }
            }

        }
        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    /**
     * 面试题62. 圆圈中最后剩下的数字
     *
     * @param n
     * @param m
     * @return 示例
     * 输入: n = 5, m = 3
     * 输出: 3
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    /**
     * 231. 2的幂
     *
     * @param n
     * @return 示例
     * <p>
     * 输入: 1
     * 输出: true
     * 解释: 20 = 1
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    /**
     * 1122. 数组的相对排序
     *
     * @param arr1
     * @param arr2
     * @return
     *
     * 示例
     *
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     *
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];
        for (int i : arr1) {
            temp[i]++;
        }
        int index=0;
        for (int j : arr2) {
            while (temp[j] >0) {
                arr1[index] = j;
                temp[j]--;
                index++;
            }
        }
        for (int i=0; i<temp.length; i++) {
            while (temp[i] >0) {
                arr1[index] = i;
                temp[i]--;
                index++;
            }
        }
        return arr1;
    }
}
