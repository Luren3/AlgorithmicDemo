package com.sflin.algorithmic.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MagicFrost
 * <p>
 * 中级其他算法
 */
public class MediumOtherUtils {

    /**
     * 22. 括号生成
     *
     * @param n
     * @return 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 例如，给出 n = 3，生成结果为：
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    private static void generate(int left, int right, int n, String s, List<String> list) {

        //条件
        if (left == n && right == n) {
            list.add(s);
            return;
        }

        //逻辑

        //下一层
        if (left < n)
            generate(left + 1, right, n, s + "(", list);
        if (left > right)
            generate(left, right + 1, n, s + ")", list);

        //清除
    }


    /**
     * 50. Pow(x, n)
     *
     * @param x
     * @param n
     * @return 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * <p>
     * 示例
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * 200. 岛屿数量
     *
     * @param grid
     * @return 示例
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * <p>
     * 输出: 1
     */
    public static int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 529. 扫雷游戏
     *
     * @param board
     * @param click
     * @return 示例
     * 输入:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'M', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * <p>
     * Click : [1,2]
     * <p>
     * 输出:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'X', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     */
    public char[][] updateBoard(char[][] board, int[] click) {

        return dfsBoard(board, click[0], click[1]);
    }

    private char[][] dfsBoard(char[][] board, int x, int y) {
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
                    if (board[i][j] == 'M')
                        count++;
            }
        }
        if (count != 0) {
            board[x][y] = (char) (count + '0');
        } else {
            board[x][y] = 'B';
            for (int i = x - 1; i <= x + 1; i++)
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
                        if (board[i][j] == 'E')
                            dfsBoard(board, i, j);
                }

        }

        return board;
    }

}
