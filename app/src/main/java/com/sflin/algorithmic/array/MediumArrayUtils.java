package com.sflin.algorithmic.array;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MagicFrost
 *
 * 中等数组算法
 */
public class MediumArrayUtils {

    /**
     * 乘积最大子序列
     *
     * @param nums
     * @return
     *
     * 示例
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i=1;i<nums.length;i++){
            int tem = max;
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min = Math.min(Math.min(tem*nums[i],min*nums[i]),nums[i]);
            result = Math.max(max,result);
        }
        return result;
    }
//    public int maxProduct(int[] nums) {
//        int result = nums[0];
//        for (int i=0;i<nums.length;i++){
//            int product = 1;
//            for (int j=i;i<nums.length;j++){
//                product *= nums[i];
//                if (product > result){
//                    result = product;
//                }
//            }
//        }
//        return result;
//    }

    /**
     * 递增的三元子序列
     *
     * @param nums
     * @return
     *
     * 示例
     * 输入: [1,2,3,4,5]
     * 输出: true
     */
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        for (int num:nums){
            if (first > num){
                first = num;
                continue;
            }
            if (first < num && num < second){
                second = num;
                continue;
            }
            if (num > second){
                return true;
            }

        }
        return false;
    }

    /**
     * 搜索二维矩阵 II
     *
     * @param matrix
     * @param target
     * @return
     *
     * 示例
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length,cols = matrix[0].length;

        int row = rows - 1,col = 0;
        while (row >= 0 && col < cols){
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] > target){
                col = 0;
                row--;
            }else {
                col++;
            }
        }
        return false;
    }
//    public boolean searchMatrix(int[][] matrix, int target) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[i].length;j++){
//                map.put(matrix[i][j],matrix[i][j]);
//            }
//        }
//        return map.containsKey(target);
//    }

    /**
     * 除自身以外数组的乘积
     *
     * @param nums
     * @return
     *
     * 示例
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n];
        int left = 1;
        int right = 1;
        for (int i=0;i<n;i++){
            newNums[i] = left;
            left *= nums[i];
        }
        for (int i=n-1;i>=0;i--){
            newNums[i] *= right;
            right *= nums[i];
        }
        return newNums;
    }
//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] newNums = new int[n];
//        int[] left = new int[n];
//        int[] right = new int[n];
//        left[0] = 1;
//        right[n-1] = 1;
//        for (int i=1;i<n;i++){
//            left[i] = nums[i-1] * left[i-1];
//            right[n-1-i] =nums[n-i] * right[n-i];
//        }
//        for (int i=0;i<nums.length;i++){
//            newNums[i] = left[i] * right[i];
//        }
//        return newNums;
//    }
//    public int[] productExceptSelf(int[] nums) {
//        int[] newNums = new int[nums.length];
//        for (int i=0;i<nums.length;i++){
//            newNums[i] = 1;
//            for (int j=0;j<nums.length;j++){
//                if (j != i){
//                    newNums[i] *= nums[j];
//                }
//            }
//        }
//        return newNums;
//    }

    /**
     * 有序矩阵中第K小的元素
     *
     * @param matrix
     * @param k
     * @return
     *
     * 示例
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     *
     * 返回 13。
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right){
            int mid = left + (right-left)/2;
            int count = 0;
            for (int i=n-1,j=0;i>=0 && j<n;){
                if (matrix[i][j] > mid){
                    i--;
                }else {
                    j++;
                    count += i+1;
                }
            }
            if (count < k){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
//    public static int kthSmallest(int[][] matrix, int k) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int n = row * col;
//        int[] arr = new int[n];
//        int index = 0;
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[i].length;j++){
//                arr[index] = matrix[i][j];
//                index++;
//            }
//        }
//        Arrays.sort(arr);
//        return arr[k];
//    }

    /**
     * 和为K的子数组
     *
     * @param nums
     * @param k
     * @return
     *
     * 示例
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;

        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(map.containsKey(sum-k))
                ret += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ret;
    }

    /**
     * 和为K的子数组(衍生)
     *
     * 给出一个正整数数组和一个数，返回一个数组走那个连续元素的和等于所给数的子数组
     *
     * @param nums
     * @param k
     * @return
     * 示例
     * 输入:nums = [9,5,4,8,9,1], k = 17
     * 输出: [5,4,8]
     */
    public static int[] continuousSum(int[] nums, int k){
        int sum = 0, start = 0, end = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            end = i;
            if(sum == k){
                end = i;
                break;
            }else if (sum > k){
                sum = sum - nums[start++];
            }
        }

        int[] arr = new int[end - start];
        for (int i=start;i<end;i++){
            arr[i-start] = nums[i+1];
        }
        return arr;
    }
//    public static int[] continuousSum(int[] nums, int k){
//        int sum = 0;
//        List<Integer> list = new ArrayList<>();
//        boolean isFind = false;
//        for (int i=0;i<nums.length;i++){
//            sum = 0;
//            for (int j=i;j<nums.length;j++){
//                sum +=nums[j];
//                list.add(nums[j]);
//                if (sum == k){
//                    isFind = true;
//                    break;
//                }
//            }
//            if (isFind) break;
//            list.clear();
//        }
//
//        int[] arr = new int[list.size()];
//        for (int i=0;i<list.size();i++){
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }

    public int test(int[] nums, int k){
        int sum = 0, index = 0, result = 0;
        for (int i=0;i<nums.length;i++){
            sum +=nums[i];
            if (sum == k){
                result++;
            }else if (sum > k){
                sum = sum - nums[index++];
            }
        }
        return result;
    }
}
