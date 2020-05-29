package com.sflin.algorithmic.sort_and_serarch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by MagicFrost
 * <p>
 * 中级排序和搜索
 */
public class MediumSortAndSearchUtils {

    /**
     * 547. 朋友圈
     *
     * @param M
     * @return 示例
     * 输入:
     * [[1,1,0],
     * [1,1,0],
     * [0,0,1]]
     * 输出: 2
     * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
     * 第2个学生自己在一个朋友圈。所以返回2。
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                findCircleNumDfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void findCircleNumDfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                findCircleNumDfs(M, visited, j);
            }
        }
    }
//    int find(int parent[], int i) {
//        if (parent[i] == -1)
//            return i;
//        return find(parent, parent[i]);
//    }
//    void union(int parent[], int x, int y) {
//        int xset = find(parent, x);
//        int yset = find(parent, y);
//        if (xset != yset)
//            parent[xset] = yset;
//    }
//    public int findCircleNum(int[][] M) {
//        int[] parent = new int[M.length];
//        Arrays.fill(parent, -1);
//        for (int i = 0; i < M.length; i++) {
//            for (int j = 0; j < M.length; j++) {
//                if (M[i][j] == 1 && i != j) {
//                    union(parent, i, j);
//                }
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < parent.length; i++) {
//            if (parent[i] == -1)
//                count++;
//        }
//        return count;
//    }

    /**
     * 130. 被围绕的区域
     *
     * @param board 示例
     *              X X X X
     *              X O O X
     *              X X O X
     *              X O X X
     *              <p>
     *              运行后
     *              X X X X
     *              X X X X
     *              X X X X
     *              X O X X
     */
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    solveDfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == '1' ? 'O' : 'X';
            }
        }
    }

    private void solveDfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '1') {
            return;
        }
        board[i][j] = '1';
        solveDfs(board, i - 1, j);
        solveDfs(board, i + 1, j);
        solveDfs(board, i, j - 1);
        solveDfs(board, i, j + 1);
    }

    /**
     * 36. 有效的数独
     *
     * @param board
     * @return 示例
     * <p>
     * 输入:
     * [
     * ["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxs = new int[9][10];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                rows[i][num]++;
                cols[j][num]++;
                boxs[(i / 3) * 3 + j / 3][num]++;
                if (rows[i][num] + cols[j][num] + boxs[(i / 3) * 3 + j / 3][num] > 3) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 433. 最小基因变化
     *
     * @param start
     * @param end
     * @param bank
     * @return 示例
     * start: "AACCGGTT"
     * end:   "AACCGGTA"
     * bank: ["AACCGGTA"]
     * <p>
     * 返回值: 1
     */
    public static int minMutation(String start, String end, String[] bank) {

        boolean[] visited = new boolean[bank.length];
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        //深度
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < bank.length; j++) {
                    //已经访问过的元素跳过,树中不存在重复节点
                    if (visited[j]) {
                        continue;
                    }
                    //孩子节点只能改变一个字符转换为s,不满足则跳过
                    String string = bank[j];
                    if (!progress(poll, string)) {
                        continue;
                    }
                    //如果节点s等于endWord,接龙完成
                    if (string.equals(end)) {
                        return res;
                    }
                    visited[j] = true;
                    queue.add(string);
                }
            }
        }
        return 0;
    }

    private static boolean progress(String poll, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (poll.charAt(i) != s.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    /**
     * 56. 合并区间
     *
     * @param intervals
     * @return
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        int mergeCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
                    if (intervals[i][1] > intervals[j][1]) {
                        intervals[j][1] = intervals[i][1];
                    }
                    if (intervals[i][0] < intervals[j][0]) {
                        intervals[j][0] = intervals[i][0];
                    }
                    intervals[i] = null;
                    mergeCount++;
                    break;
                }
            }
        }
        int[][] result = new int[intervals.length - mergeCount][];
        for (int i = 0, j = 0; j < intervals.length; j++) {
            if (intervals[j] != null) {
                result[i++] = intervals[j];
            }
        }
        return result;
    }
}
