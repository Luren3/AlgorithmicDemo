package com.sflin.algorithmic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by MagicFrost
 * <p>
 * 简单数组算法
 */
public class EasyArrayUtils {

    /**
     * 从排序数组中删除重复项
     *
     * @param nums
     * @return 示例
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
//    public static int removeDuplicates(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        for (int i =0;i < nums.length;i++){
//            if (!list.contains(nums[i])){
//                list.add(nums[i]);
//            }
//        }
//        for (int i = 0;i< list.size();i++){
//            nums[i] = list.get(i);
//        }
//        return list.size();
//    }

    /**
     * 买卖股票的最佳时机 II
     *
     * @param prices
     * @return 最大收益
     * <p>
     * 示例
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     */
    public static int maxProfit(int[] prices) {
        int value = 0;
        for (int i = 1; i < prices.length; ++i) {
            int money = prices[i] - prices[i - 1];
            value += money > 0 ? money : 0;
        }
        return value;
    }

    //    public int maxProfit(int[] prices) {
//        int total = 0;
//        int last = -1;
//        for (int i=0;i<prices.length;i++){
//            if (last != -1 && prices[i] > last){
//                total += prices[i] - last;
//            }
//            last = prices[i];
//        }
//        return total;
//    }

//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length < 1)
//            return 0;
//        int sum = 0;
//        for(int i=0;i<prices.length-1;i++){
//            int diff = prices[i+1]-prices[i];
//            if(diff > 0)
//                sum += diff;
//        }
//        return sum;
//    }

//    public static int maxProfit(int[] prices) {
//        return calculate(prices, 0);
//    }
//
//    private static int calculate(int prices[], int s) {
//        if (s >= prices.length)
//            return 0;
//        int max = 0;
//        for (int start = s; start < prices.length; start++) {
//            int maxprofit = 0;
//            for (int i = start + 1; i < prices.length; i++) {
//                if (prices[start] < prices[i]) {
//                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
//                    if (profit > maxprofit)
//                        maxprofit = profit;
//                }
//            }
//            if (maxprofit > max)
//                max = maxprofit;
//        }
//        return max;
//    }

    /**
     * 旋转数组
     *
     * @param nums
     * @param k    示例
     *             输入: [1,2,3,4,5,6,7] 和 k = 3
     *             输出: [5,6,7,1,2,3,4]
     *             解释:
     *             向右旋转 1 步: [7,1,2,3,4,5,6]
     *             向右旋转 2 步: [6,7,1,2,3,4,5]
     *             向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] numsCopy = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                nums[i] = numsCopy[nums.length - k + i];
            } else {
                nums[i] = numsCopy[i - k];
            }
        }
    }
//    public static void rotate(int[] nums, int k) {
//        if (nums.length < 2 || k < 1 || k % nums.length == 0)
//            return;
//        if (k > nums.length)
//            k = k % nums.length;
//        //1,2,3,4,5,6,7
//        reverse(nums, 0, nums.length - 1 - k);
//        //4,3,2,1,5,6,7
//        reverse(nums, nums.length - k, nums.length -1);
//        //4,3,2,1,7,6,5
//        reverse(nums, 0, nums.length - 1);
//        //5,6,7,1,2,3,4
//    }
//    private static void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start++] = nums[end];
//            nums[end--] = temp;
//        }
//    }

    /**
     * 存在重复元素
     *
     * @param nums
     * @return 示例
     * 输入: [1,2,3,1]
     * 输出: true
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                num = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
//    public static boolean containsDuplicate(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i :nums){
//            if (map.containsKey(i)){
//                return true;
//            }
//            map.put(i,i);
//        }
//        return false;
//    }

    /**
     * 只出现一次的数字
     *
     * @param nums
     * @return 示例
     * 输入: [2,2,1]
     * 输出: 1
     */
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
//    public int singleNumber(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i=0;i<nums.length;i++){
//            if (map.containsKey(nums[i])){
//                map.remove(nums[i]);
//            }else {
//                map.put(nums[i],nums[i]);
//            }
//        }
//        return (int) map.keySet().toArray()[0];
//    }

    /**
     * 两个数组的交集 II
     *
     * @param nums1
     * @param nums2
     * @return 示例
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        for (int num : (nums1.length >= nums2.length ? nums1 : nums2)) {
            numList.add(num);
        }

        for (int num : (nums1.length < nums2.length ? nums1 : nums2)) {
            if (numList.contains(num)) {
                list.add(num);
                numList.remove(numList.indexOf(num));
            }
        }

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    /**
     * 加一
     *
     * @param digits
     * @return 示例
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 逢十进一
     */
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            int number = digits[i] + 1;

            if (number == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] newArr = new int[digits.length + 1];
                    newArr[0] = 1;
                    return newArr;
                }
            } else {
                digits[i] = number;
                break;
            }
        }

        return digits;
    }

    /**
     * 移动零
     *
     * @param nums 示例
     *             输入: [1,0,0,3,12]
     *             输出: [1,3,12,0,0]
     *             <p>
     *             说明:
     *             必须在原数组上操作，不能拷贝额外的数组。
     *             尽量减少操作次数。
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (j < i) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
//    public static void moveZeroes(int[] nums) {
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[j++] = nums[i];
//            }
//        }
//        while (j < nums.length) {
//            nums[j] = 0;
//            j++;
//        }
//    }
//    public static void moveZeroes(int[] nums) {
//        int index = 0;
//        for(int i = 0;i < nums.length;i ++){
//            if (nums[i] != 0) continue;
//            index++;
//        }
//        if (index == nums.length) return;
//        for(int i = 0;i < nums.length - 1;i ++){
//            if (nums[i] != 0) continue;
//            for (int j = i;j < nums.length - 1;j ++){
//                int temp = nums[j];
//                nums[j] = nums[j + 1];
//                nums[j + 1] = temp;
//            }
//            if (nums[i] == 0 && i < (nums.length - index)) {
//                i--;
//            }
//        }
//    }

    /**
     * 1.两数之和
     *
     * @param nums
     * @param target
     * @return 示例
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];

            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
//    public int[] twoSum(int[] nums, int target) {
//        int[] sum = new int[2];
//        for (int i = 0;i < nums.length - 1;i ++){
//            for(int j = i+1;j < nums.length;j ++){
//                if ((nums[i] + nums[j]) == target){
//                    sum[0] = i;
//                    sum[1] = j;
//                    return sum;
//                }
//            }
//        }
//        return sum;
//    }

    /**
     * 有效的数独
     *
     * @param board
     * @return 示例
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
        Map<Integer, Map<Character, Character>> rowMap = new HashMap<>();
        Map<Integer, Map<Character, Character>> colMap = new HashMap<>();
        Map<Integer, Map<Character, Character>> blockMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char num = board[i][j];
                    if ((rowMap.get(i) != null && rowMap.get(i).containsKey(num))
                            || (colMap.get(j) != null && colMap.get(j).containsKey(num))
                            || (blockMap.get(i / 3 * 3 + j / 3) != null && blockMap.get(i / 3 * 3 + j / 3).containsKey(num))) {
                        return false;
                    } else {
                        addValue(rowMap, i, num);
                        addValue(colMap, j, num);
                        addValue(blockMap, i / 3 * 3 + j / 3, num);
                    }
                }
            }
        }
        return true;
    }

    private void addValue(Map<Integer, Map<Character, Character>> map, int index, char num) {
        if (map.get(index) == null) {
            Map<Character, Character> newMap = new HashMap<>();
            newMap.put(num, num);
            map.put(index, newMap);
        } else {
            map.get(index).put(num, num);
        }
    }

    /**
     * 旋转图像
     *
     * @param matrix 示例
     *               给定 matrix =
     *               [
     *               [1,2,3],
     *               [4,5,6],
     *               [7,8,9]
     *               ],
     *               <p>
     *               原地旋转输入矩阵，使其变为:
     *               [
     *               [7,4,1],
     *               [8,5,2],
     *               [9,6,3]
     *               ]
     */
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int start = i;
            int end = matrix.length - 1 - i;
            for (int j = 0; j < end - start; j++) {
                int temp = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = temp;
            }
        }
    }
//    public static void rotate(int[][] matrix) {
//        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
//        for(int i = 0;i < matrix.length;i ++){
//            for (int j = 0;j < matrix[i].length;j ++){
//                if (map.get(i) == null){
//                    Map<Integer,Integer> newMap = new HashMap<>();
//                    newMap.put(j,matrix[i][j]);
//                    map.put(i,newMap);
//                }else {
//                    map.get(i).put(j,matrix[i][j]);
//                }
//            }
//        }
//        for(int i = 0;i < matrix.length;i ++){
//            for (int j = 0;j < matrix[i].length;j ++){
//                matrix[j][matrix.length - 1 - i] = map.get(i).get(j);
//            }
//        }
//    }

    /**
     * 求众数
     *
     * @param nums
     * @return 示例
     * 输入: [3,2,3]
     * 输出: 3
     */
    public static int majorityElement(int[] nums) {
        int num = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                index++;
            } else {
                index--;
                if (index == 0 && i < nums.length - 1) {
                    num = nums[i + 1];
                }
            }
        }
        return num;
    }
//    public static int majorityElement(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int n:nums){
//            if (!map.containsKey(n)){
//                map.put(n,1);
//            }else {
//                int value = map.get(n);
//                value++;
//                map.put(n,value);
//            }
//        }
//        int num = nums[0];
//        int index = map.get(num);
//        for (int key:map.keySet()){
//            int value = map.get(key);
//            if (index < value){
//                index = value;
//                num = key;
//            }
//        }
//        return num;
//    }

    /**
     * 40. 最小的k个数
     *
     * @param arr
     * @param k
     * @return 示例
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        //默认小顶堆实现
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
//    public static int[] getLeastNumbers(int[] arr, int k) {
//        int[] newArr = new int[k];
//
//        Arrays.sort(arr);
//        for (int i = 0; i < k; i++) {
//            newArr[i] = arr[i];
//        }
//        return newArr;
//    }

    /**
     * 455. 分发饼干
     *
     * @param g
     * @param s
     * @return 示例
     * 输入: [1,2,3], [1,1]
     * <p>
     * 输出: 1
     * <p>
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        for (; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }

    /**
     * 874. 模拟行走机器人
     *
     * @param commands
     * @param obstacles
     * @return
     *
     * 示例
     * 输入: commands = [4,-1,3], obstacles = []
     * 输出: 25
     * 解释: 机器人将会到达 (3, 4)
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 860. 柠檬水找零
     *
     * @param bills
     * @return
     *
     * 示例
     * 输入：[5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public void test(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2] +arr[i-3];
        }
    }

    public void test2(int n) {

    }
}
