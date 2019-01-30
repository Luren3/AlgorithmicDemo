package com.sflin.algorithmic.array;

import java.util.*;

/**
 * Created by MagicFrost
 *
 * 初级数组算法
 */
public class EasyArrayUtils {

    /**
     * 从排序数组中删除重复项
     *
     * @param nums
     * @return
     *
     * 示例
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i =0;i < nums.length;i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        for (int i = 0;i< list.size();i++){
            nums[i] = list.get(i);
        }
        return list.size();
    }

    /**
     * 买卖股票的最佳时机 II
     *
     * @param prices
     * @return 最大收益
     *
     * 示例
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
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
     * @param k
     *
     * 示例
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public static void rotate(int[] nums, int k) {
        if (k < 0) k =nums.length - Math.abs(k) % nums.length;
        if (k > nums.length) k = k % nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }
        for (int i=0;i<nums.length;i++){
            if (i < k){
                nums[i] = map.get(nums.length - k + i);
            }else {
                nums[i] = map.get(i - k);
            }
        }
    }

    /**
     * 存在重复
     *
     * @param nums
     * @return
     *
     * 示例
     * 输入: [1,2,3,1]
     * 输出: true
     */
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i :nums){
            if (map.containsKey(i)){
                return true;
            }
            map.put(i,i);
        }
        return false;
    }

    /**
     * 只出现一次的数字
     *
     * @param nums
     * @return
     *
     * 示例
     * 输入: [2,2,1]
     * 输出: 1
     */
    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i=1;i<nums.length;i++){
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
     * @return
     *
     * 示例
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        for (int num:(nums1.length>=nums2.length?nums1:nums2)){
            numList.add(num);
        }

        for (int num:(nums1.length<nums2.length?nums1:nums2)){
            if (numList.contains(num)){
                list.add(num);
                numList.remove(numList.indexOf(num));
            }
        }

        int[] nums = new int[list.size()];
        for (int i=0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        return nums;
    }

    /**
     * 加一
     *
     * @param digits
     * @return
     *
     * 示例
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 逢十进一
     */
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length -1;i >= 0;i --){
            int number = digits[i] + 1;

            if (number == 10){
                digits[i] = 0;
                if (i == 0){
                    int[] newArr = new int[digits.length + 1];
                    newArr[0] = 1;
                    return newArr;
                }
            }else {
                digits[i] = number;
                break;
            }
        }

        return digits;
    }

    /**
     * 移动零
     *
     * @param nums
     *
     * 示例
     * 输入: [1,0,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!= 0){
                nums[j++] = nums[i];
            }
        }
        while(j < nums.length){
            nums[j] = 0;
            j++;
        }
    }
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
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     *
     * 示例
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++){
            int value = target - nums[i];

            if (map.containsKey(value)){
                return new int[]{map.get(value),i};
            }
            map.put(nums[i],i);
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
     * @return
     *
     * 示例
     * 输入:
     * [
     *   ["5","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     */
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Map<Character,Character>> rowMap = new HashMap<>();
        Map<Integer,Map<Character,Character>> colMap = new HashMap<>();
        Map<Integer,Map<Character,Character>> blockMap = new HashMap<>();

        for (int i = 0;i < 9;i ++){
            for (int j = 0;j < 9;j ++){
                if (board[i][j] != '.'){
                    char num = board[i][j];
                    if ((rowMap.get(i) != null && rowMap.get(i).containsKey(num))
                            || (colMap.get(j) != null && colMap.get(j).containsKey(num))
                            || (blockMap.get(i / 3 * 3 + j / 3) != null && blockMap.get(i / 3 * 3 + j / 3).containsKey(num))){
                        return false;
                    }else {
                        addValue(rowMap,i,num);
                        addValue(colMap,j,num);
                        addValue(blockMap,i / 3 * 3 + j / 3,num);
                    }
                }
            }
        }
        return true;
    }
    private void addValue(Map<Integer,Map<Character,Character>> map,int index,char num){
        if (map.get(index) == null){
            Map<Character,Character> newMap = new HashMap<>();
            newMap.put(num,num);
            map.put(index,newMap);
        }else {
            map.get(index).put(num,num);
        }
    }

    /**
     * 旋转图像
     *
     * @param matrix
     *
     * 示例
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     */
    public static void rotate(int[][] matrix) {
        for(int i = 0;i < matrix.length / 2;i ++){
            int start = i;
            int end = matrix.length - 1 - i;
            for (int j = 0;j < end - start;j ++){
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
}
