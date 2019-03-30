package com.sflin.algorithmic.stack;

import java.util.PriorityQueue;

/**
 * Created by MagicFrost
 *
 * 中等堆、栈和队列算法
 */
public class MediumStackUtils {

    /**
     * 数组中的第K个最大元素
     *
     * @param nums
     * @param k
     * @return
     *
     * 示例
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num:nums){
            queue.add(num);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
//    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
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
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];
        while (min < max){
            int mid = min + (max-min)/2;
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
                min = mid + 1;
            }else {
                max = mid;
            }
        }
        return min;
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
}
